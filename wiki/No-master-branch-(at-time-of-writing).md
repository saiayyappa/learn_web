We had an issue [#37](https://github.com/KirstieJane/STEMMRoleModels/issues/37) that discussed getting rid of the default `master` branch.

What follows are [Abby's](https://github.com/acabunoc) comments suggesting the action that we've taken at this point, to have only a `gh-pages` branch. (Although there's a good chance that `dev` will arrive at some point!

**On dev + master**:

Yes, `dev` + `master` is a common development workflow and I think having some sort of `dev` branch is very smart! Great points @grprtkal & @KirstieJane.

The difference here (which @jvoytek has nicely pointed out) is that on GitHub, `gh-pages` is a [magical branch](https://help.github.com/categories/github-pages-basics/) that will also deploy your static site! It's powering your site here: http://kirstiejane.github.io/STEMMRoleModels/ and [this](https://github.com/KirstieJane/STEMMRoleModels/blob/master/CNAME) makes it show up here, too: http://stemmrolemodels.com/

Given that you need `gh-pages` to power your current site, it doesn't make sense (to me) to continuously keep this up to date with your `master` branch. So, I suggested removing `master` altogether. I have no objections to adding `dev` if you want to!

**On using a server instead of gh-pages**:

Down the road, if you decide to use a server (for a database or server-side rendering, etc) then yes, you will outgrow `gh-pages` (and I ❤️ AWS, @jvoytek). Any server side development would ideally happen on a branch *not* named `gh-pages`, since it would break that magic. `master` would be an acceptable name.

**On building your prototype on gh-pages**:

However, given the scope of this project, I think you should be able to build a prototype web app on a static site (i.e. hosted completely `gh-pages`) using Google Spreadsheets / Google Forms / some fancy javascript.

Here's an example `gh-pages` site. Each 'Event Report' is taken from a google spreadsheet.
http://mozilla.github.io/clubs-events/

You can add a new 'Event Report' by filling out this form (go ahead! This is test data right now):
https://docs.google.com/a/mozillafoundation.org/forms/d/1TxqagaZED7DqroHN8obx0yr9n3A3pwl84_46rTER91c/viewform?c=0&w=1

Here is all the code & some explanations:
https://github.com/mozilla/clubs-events/

I would encourage you to go in this direction and learn from the example above since you already have a gh-pages site and google forms/sheets are relatively easy to use. This will get you up and running fairly quickly (I think luke built this in a week) - and the sooner you can show a working prototype to people, the better 😄 

Note: If you have a contributor that is a database expert and can get you setup quickly, then by all means, skip the `gh-pages` site!

---

Sorry that was so long! I also wanted to say that I'm really impressed with how this work and community is coming together! There's been some amazing buzz and activity here, keep it up 👍 💯 

