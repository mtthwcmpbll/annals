# annals
A simple service for recording personal data.

## Building & Releasing

This project uses a combination of `git-flow` branching and Netflix's `nebula-release` gradle plugin.  All work is done on the _develop_ branch or one of the various feature branches.  You can build the current working version with the following:

```
git checkout develop
./gradlew clean snapshot
```

To cut a new release, use the git-flow extensions to start and finish a release:

```
# replace VERSION with x.y.z semantic version number
git flow release start VERSION
git flow release finish VERSION
``` 

The git-flow extension will automatically merge things into master and tag the release with `vVERSION`. Push these commits to master and the CircleCI build will automatically kick off, detecting the tag with the nebula-release gradle plugin and building the correct artifact.