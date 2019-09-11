When you create a [fork](https://help.github.com/articles/github-glossary/#fork) of a [repository](https://help.github.com/articles/github-glossary/#repository) ([here are some instructions](https://help.github.com/articles/fork-a-repo/)) you only have the versions of the files that are in the repository at that time. So if there are any changes in the original repository you may find that your version (your fork) is out of sync.

This can lead to problems when you try to create a [pull request](https://help.github.com/articles/github-glossary/#pull-request). 

While GitHub has instructions for [merging an upstream repository into your fork](https://help.github.com/articles/merging-an-upstream-repository-into-your-fork/) they require you to have git installed on your local machine.

Fortunately, when Kirstie reached out to the cool kids from the [Mozilla Science Working Open Workshop](https://www.mozillascience.org/working-open-workshop-february-2016) they gave her the answer. And it turns out there was an answer on the interwebs already: you **can update your fork in the browser** by following the easy steps laid out in [this Stack Overflow answer](http://stackoverflow.com/questions/20984802/how-can-i-keep-my-fork-in-sync-without-adding-a-separate-remote/21131381#21131381).

The Stack Overflow [link](http://stackoverflow.com/questions/20984802/how-can-i-keep-my-fork-in-sync-without-adding-a-separate-remote/21131381#21131381) has pictures which are really helpful, but briefly, here's what you do:

1. Open **your** fork of the repository.

2. Click the compare button.

    This will open a page titled **Comparing Changes** and if you look carefully you'll have jumped to the upstream version of the repository. If you were to do a regular pull request then this makes sense as you'd be bringing your changes into the upstream version. But in this case we want to **flip the direction** and pull changes *from* the original version *to* our fork.

3. Change the **base fork** to your repository

4. You're now back to your fork but you've also asked to compare two identical repositories so GitHub thinks you care about [branches](https://help.github.com/articles/github-glossary/#branch) not [forks](https://help.github.com/articles/github-glossary/#fork). Click on **compare across forks** to get back your base fork option.

5. Change the **head fork** to the upstream (original) repository

    Note at this point that if you were in control of everything at GitHub you would probably just have put a little button in between the base for and head fork that would have flipped them for you rather than doing all these clicks. You might even had added in a separate button to check for upstream changes! But [they do know that this is a bit of a silly hack](https://github.com/isaacs/github/issues/121) and they're working hard on a bunch of other cool stuff so we'll let them off this one.

6. You'll see one of two options:
 + "There isn’t anything to compare"
  This means you're up to date and you don't have to do anything. Phew. :relieved:
 + A list of commits.
  These are the changes that have happened in the repository since you forked your version. Go to step 7.

7. Create a [pull request](https://help.github.com/articles/github-glossary/#pull-request)

    Note that this pull request is **to you**! So you can confirm that it's ok and merge it when necessary. And if there are any merge conflicts then it's up to you to figure out what's gone wrong and sort them out.

And now you're ready to continue working on your fork :smiley: :boom: :tada: 

Well done!