const states = {
  pending: 'Pending',
  resolved: 'Resolved',
  rejected: 'Rejected'
};

class Nancy {
  constructor(executor) {
    const tryCall = callback => Nancy.try(() => callback(this.value));
    const laterCalls = [];
    const callLater = getMember => callback => new Nancy(resolve => laterCalls.push(() => resolve(getMember()(callback))));
    const members = {
      [states.resolved]: {
        state: states.resolved,
        then: tryCall,
        catch: _ => this
      },
      [states.rejected]: {
        state: states.rejected,
        then: _ => this,
        catch: tryCall
      },
      [states.pending]: {
        state: states.pending,
        then: callLater(() => this.then),
        catch: callLater(() => this.catch)
      }
    };
    const changeState = state => Object.assign(this, members[state]);
    const apply = (value, state) => {
      if (this.state === states.pending) {
        this.value = value;
        changeState(state);
        for (const laterCall of laterCalls) {
          laterCall();
        }
      }
    };

    const getCallback = state => value => {
      if (value instanceof Nancy && state === states.resolved) {
        value.then(value => apply(value, states.resolved));
        value.catch(value => apply(value, states.rejected));
      } else {
        apply(value, state);
      }
    };

    const resolve = getCallback(states.resolved);
    const reject = getCallback(states.rejected);
    changeState(states.pending);
    try {
      executor(resolve, reject);
    } catch (error) {
      reject(error);
    }
  }

  static resolve(value) {
    return new Nancy(resolve => resolve(value));
  }

  static reject(value) {
    return new Nancy((_, reject) => reject(value));
  }

  static try(callback) {
    return new Nancy(resolve => resolve(callback()));
  }
}

function fakeAjax(url, cb) {
  var fake_responses = {
    "file1": "The first text",
    "file2": "The middle text",
    "file3": "The last text"
  };
  var randomDelay = (Math.round(Math.random() * 1E4) % 8000) + 1000;

  console.log("Requesting: " + url);

  setTimeout(function () {
    cb(fake_responses[url]);
  }, randomDelay);
}

function output(text) {
  console.log(text);
}


function output(text) {
  console.log(text);
}

function getFile(file) {
  return new Nancy(function (resolve) {
    fakeAjax(file, resolve);
  });
}

var p1 = getFile("file1");
var p2 = getFile("file2");
var p3 = getFile("file3")

p1
  .then(output)
  .then(function () {
    return p2;
  })
  .then(output)
  .then(function () {
    return p3
  })
  .then(output)
  .catch(function () {
    console.log('error');
  });