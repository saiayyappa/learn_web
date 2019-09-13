// State machine to keep track of the states
var PENDING = 0; var FULFILLED = 1; var REJECTED = 2;

// Promise1 fn accepting another fn as arg
function Promise1(fn) {
  // to store state
  var state = PENDING;
  // store value or error once FULFILLED or REJECTED
  var value = null;
  // store sucess & failure handlers attached by calling .then or .done
  var handlers = [];

  function fulfill(result) {
    state = FULFILLED;
    value = result;
    handlers.forEach(handle);
    handlers = null;
  }

  function reject(error) {
    state = REJECTED;
    value = error;
    handlers.forEach(handle);
    handlers = null;
  }

  function resolve(result) {
    try {
      var then = getThen(result);
      if (then) {
        doResolve(then.bind(result), resolve, reject)
        return
      }
      fulfill(result);
    } catch (e) {
      reject(e);
    }
  }

  function handle(handler) {
    if (state === PENDING) {
      handlers.push(handler);
    } else {
      if (state === FULFILLED &&
        typeof handler.onFulfilled === 'function') {
        handler.onFulfilled(value);
      }
      if (state === REJECTED &&
        typeof handler.onRejected === 'function') {
        handler.onRejected(value);
      }
    }
  }

  this.then = function (onFulfilled, onRejected) {
    var self = this;
    return new Promise1(function (resolve, reject) {
      return self.done(function (result) {
        if (typeof onFulfilled === 'function') {
          try {
            return resolve(onFulfilled(result));
          } catch (ex) {
            return reject(ex);
          }
        } else {
          return resolve(result);
        }
      }, function (error) {
        if (typeof onRejected === 'function') {
          try {
            return resolve(onRejected(error));
          } catch (ex) {
            return reject(ex);
          }
        } else {
          return reject(error);
        }
      });
    });
  }

  this.done = function (onFulfilled, onRejected) {
    // ensure we are always asynchronous
    setTimeout(function () {
      handle({
        onFulfilled: onFulfilled,
        onRejected: onRejected
      });
    }, 0);
  }

  doResolve(fn, resolve, reject);
}

function getThen(value) {
  var t = typeof value;
  if (value && (t === 'object' || t === 'function')) {
    var then = value.then;
    if (typeof then === 'function') {
      return then;
    }
  }
  return null;
}

function doResolve(fn, onFulfilled, onRejected) {
  var done = false;
  try {
    fn(function (value) {
      if (done) return
      done = true
      onFulfilled(value)
    }, function (reason) {
      if (done) return
      done = true
      onRejected(reason)
    })
  } catch (ex) {
    if (done) return
    done = true
    onRejected(ex)
  }
}

// Consuming the process by file ajax call

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



function getFile(file) {
  return new Promise1(function (resolve) {
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
    return p3;
  })
  .then(output)


// this.then = function (onFulfilled, onRejected) {
//   var self = this;
//   return new Promise(function (resolve, reject) {
//     return self.done(function (result) {
//       if (typeof onFulfilled === 'function') {
//         try {
//           return resolve(onFulfilled(result));
//         } catch (ex) {
//           return reject(ex);
//         }
//       } else {
//         return resolve(result);
//       }
//     }, function (error) {
//       if (typeof onRejected === 'function') {
//         try {
//           return resolve(onRejected(error));
//         } catch (ex) {
//           return reject(ex);
//         }
//       } else {
//         return reject(error);
//       }
//     });
//   });
// }


// this.done = function (onFulfilled, onRejected) {
//   // ensure we are always asynchronous
//   setTimeout(function () {
//     handle({
//       onFulfilled: onFulfilled,
//       onRejected: onRejected
//     });
//   }, 0);
// }