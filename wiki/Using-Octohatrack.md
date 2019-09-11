[Octohatrack](https://github.com/LABHR/octohatrack) takes a github repo name, and returns a list of every github user that has interacted with a project, whether they have committed code or commented in the issues. It even makes a nice little html page so that we can see everyone's beautiful faces :smiley:

At the moment, Kirstie has installed `octohatrack` on her (Windows) laptop, created a GITHUB_TOKEN and can simply open an `anaconda command prompt` and run the following commands from inside the `octohatrack_output` folder in her local copy of the `STEMMRoleModels` repository.

You can tell when it was last run because the [output page](http://kirstiejane.github.io/STEMMRoleModels/octohatrack_output/KirstieJane_STEMMRoleModels_contrib.html) puts the date down at the bottom.

These are the commands:

    set GITHUB_TOKEN=###replace_with_token_code###
    octohatrack -g -c -n KirstieJane/STEMMRoleModels

Boom :tada: :balloon: :sparkles: 

Don't forget to then merge these changes into the `gh-pages` branch.
