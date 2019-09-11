Following the instructions from http://metafizzy.co/blog/one-docs-to-rule-them-all (and on a Windows machine because Kirstie uses a windows laptop!)

1. Open the Git Shell

2. Make sure you're in the `master` branch and that everything is up to date

        git checkout master
        git commit -m "Enter your commit message here" -a

3. Now switch to the `gh-pages` branch and merge `master`

        git checkout gh-pages
        git merge master

4. Note here that you might get a message along the lines of:

        CONFLICT (modify/delete): octohatrack_output/cache_file.json deleted in HEAD
        and modified in master. Version master of octohatrack_output/cache_file.json 
        left in tree.

    In this case if you want the version from master then you're ok - that's the one that has been "left in tree".

    However, if you see:

        CONFLICT (add/add): Merge conflict in octohatrack_output/KirstieJane_STEMMRoleModels_contrib.html
        Automatic merge failed; fix conflicts and then commit the result.

    Then you're going to have to manually edit these files to get rid of the `<<<<<<< HEAD` etc markers.
    A good place to start is this help page: https://help.github.com/articles/resolving-a-merge-conflict-from-the-command-line.

5. Once you've dealt with the merge conflicts though, go ahead and push the changes:

        git commit -m "keeping up to date with master" -a
        git push

