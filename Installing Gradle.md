## Install SDK


* Open a Terminal window
* Paste in the following command and return to execute.  

```
   curl -s http://get.sdkman.io | bash
```

* Follow the directions, either copy & paste the following command or open a new Terminal window

```
    source "$HOME/.sdkman/bin/sdkman-init.sh"
```

* Verify with the following command

```
    sdk version
```

* Other SDK commands can be access by running `sdk` from the command line. *Details at [SDK](http://sdkman.io)*

## Install Gradle

* Install the latest version of Gradle:

```
    sdk install gradle
```

* Once download is complete, verify with:

```
    gradle --version
```

* Set your current directory to the one contain the ```build.gradle``` file
* Use the Gradle task ```usage``` to view the build documentation

```
    gradle usage
```

## Useful bash shell aliases for use with Gradle 

```
if [ -n  "$interactive" ]; then

    alias tasks='gradle --console=plain tasks'
    alias clean='gradle --quiet --console=plain clean'
    alias usage='gradle --quiet --console=plain usage'
    alias report='open target/reports/tests/index.html 2>/dev/null;'
          
    function test { gradle --console=plain test -Dtest.single=${1}; }
    function tests { gradle --console=plain test; }
fi

```


