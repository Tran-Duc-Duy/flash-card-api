# Flash Card API
## 1.  Ussing Spring, JPA, MySQL server.
## 2. Git flow and GitHub.  
- Create project in IDE, create a new repository in GitHub.
- git init
- git commit -a -m "init"
- git remote add origin <git_url>
- git push -u origin master
- git checkout -b develop
- git push -u origin develop
- Create issue in GitHub. Add a description of the issue. Memorize #number_of_issues
- Code
- git checkout -b tag_name/number_of_issues-issue_name develop
- git commit -a -m "#number_of_issues-issue_name-done"
- git push -u origin tag_name/number_of_issues-issue_name
- pull request to develop, merge to develop
- git checkout develop
- git pull 
- git checkout -b release-1.0.0 develop 
- git tag 'v1.0.0'
- git push --tags
- git push --set-upstream origin release-1.0.0
- pull request to master, merge to master
- git checkout master
- git pull
- git branch -d release-1.0.0
- git push origin -d release-1.0.0
- git branch -d feature/1-init-connect-sql
- git push origin -d feature/1-init-connect-sql