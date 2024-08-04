
# Resemos de Git e GitHub

Uma breve descrição sobre o que esse projeto faz e para quem ele é 
[DIO(link)]

## documentação
- Teste 1
-Teste 2

## tabela

| Aulas | Resumos |
|-------| --------|
|Teste aulas | Aulas teste |

```
git init

```

## lista
- teste
- teste 2


Alaiane@DESKTOP-UKVV7MO MINGW64 ~/Desktop/java
$ git init
Initialized empty Git repository in C:/Users/Alaiane/Desktop/java/.git/
gi
Alaiane@DESKTOP-UKVV7MO MINGW64 ~/Desktop/java (master)
$ git status
On branch master

No commits yet

Untracked files:
  (use "git add <file>..." to include in what will be committed)
        readme.md

nothing added to commit but untracked files present (use "git add" to track)

Alaiane@DESKTOP-UKVV7MO MINGW64 ~/Desktop/java (master)
$ git add .

Alaiane@DESKTOP-UKVV7MO MINGW64 ~/Desktop/java (master)
$ git status
On branch master

No commits yet

Changes to be committed:
  (use "git rm --cached <file>..." to unstage)
        new file:   readme.md


Alaiane@DESKTOP-UKVV7MO MINGW64 ~/Desktop/java (master)
$ git commit -m "readme"
[master (root-commit) 6fb66f7] readme
 1 file changed, 26 insertions(+)
 create mode 100644 readme.md

Alaiane@DESKTOP-UKVV7MO MINGW64 ~/Desktop/java (master)
$ git remote add origin https://github.com/ux-pages/gitest.git

Alaiane@DESKTOP-UKVV7MO MINGW64 ~/Desktop/java (master)
$ git push -u origin main
error: src refspec main does not match any
error: failed to push some refs to 'https://github.com/ux-pages/gitest.git'

Alaiane@DESKTOP-UKVV7MO MINGW64 ~/Desktop/java (master)
$ git push -u origin master
Enumerating objects: 3, done.
Counting objects: 100% (3/3), done.
Delta compression using up to 4 threads
Compressing objects: 100% (2/2), done.
Writing objects: 100% (3/3), 404 bytes | 67.00 KiB/s, done.
Total 3 (delta 0), reused 0 (delta 0), pack-reused 0 (from 0)
To https://github.com/ux-pages/gitest.git
 * [new branch]      master -> master
branch 'master' set up to track 'origin/master'.

Alaiane@DESKTOP-UKVV7MO MINGW64 ~/Desktop/java (master)
$ git log
commit 6fb66f7321ae34694af94cff4259d8c40696a87a (HEAD -> master, origin/master)
Author: ux-pages <contato.ux.pages@gmail.com>
Date:   Sat Aug 3 23:03:51 2024 -0300

    readme

Alaiane@DESKTOP-UKVV7MO MINGW64 ~/Desktop/java (master)
$ git checkou -b teste
git: 'checkou' is not a git command. See 'git --help'.

The most similar command is
        checkout

Alaiane@DESKTOP-UKVV7MO MINGW64 ~/Desktop/java (master)
$ echo "comiit" > commit.txt

Alaiane@DESKTOP-UKVV7MO MINGW64 ~/Desktop/java (master)
$ git add .
warning: in the working copy of 'commit.txt', LF will be replaced by CRLF the next time Git touches it

Alaiane@DESKTOP-UKVV7MO MINGW64 ~/Desktop/java (master)
$ git commit -m"commit 1"
[master 66c03d9] commit 1
 1 file changed, 1 insertion(+)
 create mode 100644 commit.txt

Alaiane@DESKTOP-UKVV7MO MINGW64 ~/Desktop/java (master)
$ git log
commit 66c03d9e774b4af2b90c79e5f1bd0b08bde62085 (HEAD -> master)
Author: ux-pages <contato.ux.pages@gmail.com>
Date:   Sat Aug 3 23:12:00 2024 -0300

    commit 1

commit 6fb66f7321ae34694af94cff4259d8c40696a87a (origin/master)
Author: ux-pages <contato.ux.pages@gmail.com>
Date:   Sat Aug 3 23:03:51 2024 -0300

    readme

Alaiane@DESKTOP-UKVV7MO MINGW64 ~/Desktop/java (master)
$ git checkou -b teste
git: 'checkou' is not a git command. See 'git --help'.

The most similar command is
        checkout

Alaiane@DESKTOP-UKVV7MO MINGW64 ~/Desktop/java (master)
$ git checkout -b teste
Switched to a new branch 'teste'

Alaiane@DESKTOP-UKVV7MO MINGW64 ~/Desktop/java (teste)
$ git log
commit 66c03d9e774b4af2b90c79e5f1bd0b08bde62085 (HEAD -> teste, master)
Author: ux-pages <contato.ux.pages@gmail.com>
Date:   Sat Aug 3 23:12:00 2024 -0300

    commit 1

commit 6fb66f7321ae34694af94cff4259d8c40696a87a (origin/master)
Author: ux-pages <contato.ux.pages@gmail.com>
Date:   Sat Aug 3 23:03:51 2024 -0300

    readme

Alaiane@DESKTOP-UKVV7MO MINGW64 ~/Desktop/java (teste)
$ echo "teste 01" > teste01.txt

Alaiane@DESKTOP-UKVV7MO MINGW64 ~/Desktop/java (teste)
$ git log
commit 66c03d9e774b4af2b90c79e5f1bd0b08bde62085 (HEAD -> teste, master)
Author: ux-pages <contato.ux.pages@gmail.com>
Date:   Sat Aug 3 23:12:00 2024 -0300

    commit 1

commit 6fb66f7321ae34694af94cff4259d8c40696a87a (origin/master)
Author: ux-pages <contato.ux.pages@gmail.com>
Date:   Sat Aug 3 23:03:51 2024 -0300

    readme

Alaiane@DESKTOP-UKVV7MO MINGW64 ~/Desktop/java (teste)
$ git add .
warning: in the working copy of 'teste01.txt', LF will be replaced by CRLF the next time Git touches it
g
Alaiane@DESKTOP-UKVV7MO MINGW64 ~/Desktop/java (teste)
$ git commit -m "teste"
[teste 19f173b] teste
 1 file changed, 1 insertion(+)
 create mode 100644 teste01.txt

Alaiane@DESKTOP-UKVV7MO MINGW64 ~/Desktop/java (teste)
$ git lo
git: 'lo' is not a git command. See 'git --help'.

The most similar commands are
        log
        flow

Alaiane@DESKTOP-UKVV7MO MINGW64 ~/Desktop/java (teste)
$ git log
commit 19f173b2955ea85cbd8ba41b5f49ec841f6e15bc (HEAD -> teste)
Author: ux-pages <contato.ux.pages@gmail.com>
Date:   Sat Aug 3 23:13:55 2024 -0300

    teste

commit 66c03d9e774b4af2b90c79e5f1bd0b08bde62085 (master)
Author: ux-pages <contato.ux.pages@gmail.com>
Date:   Sat Aug 3 23:12:00 2024 -0300

    commit 1

commit 6fb66f7321ae34694af94cff4259d8c40696a87a (origin/master)
Author: ux-pages <contato.ux.pages@gmail.com>
Date:   Sat Aug 3 23:03:51 2024 -0300

    readme

Alaiane@DESKTOP-UKVV7MO MINGW64 ~/Desktop/java (teste)
$ git checkout master
Switched to branch 'master'
Your branch is ahead of 'origin/master' by 1 commit.
  (use "git push" to publish your local commits)

Alaiane@DESKTOP-UKVV7MO MINGW64 ~/Desktop/java (master)
$ git log
commit 66c03d9e774b4af2b90c79e5f1bd0b08bde62085 (HEAD -> master)
Author: ux-pages <contato.ux.pages@gmail.com>
Date:   Sat Aug 3 23:12:00 2024 -0300

    commit 1

commit 6fb66f7321ae34694af94cff4259d8c40696a87a (origin/master)
Author: ux-pages <contato.ux.pages@gmail.com>
Date:   Sat Aug 3 23:03:51 2024 -0300

    readme

Alaiane@DESKTOP-UKVV7MO MINGW64 ~/Desktop/java (master)
$ git merge teste
Updating 66c03d9..19f173b
Fast-forward
 teste01.txt | 1 +
 1 file changed, 1 insertion(+)
 create mode 100644 teste01.txt

Alaiane@DESKTOP-UKVV7MO MINGW64 ~/Desktop/java (master)
$ git loh
git: 'loh' is not a git command. See 'git --help'.

The most similar command is
        log

Alaiane@DESKTOP-UKVV7MO MINGW64 ~/Desktop/java (master)
$ git log
commit 19f173b2955ea85cbd8ba41b5f49ec841f6e15bc (HEAD -> master, teste)
Author: ux-pages <contato.ux.pages@gmail.com>
Date:   Sat Aug 3 23:13:55 2024 -0300

    teste

commit 66c03d9e774b4af2b90c79e5f1bd0b08bde62085
Author: ux-pages <contato.ux.pages@gmail.com>
Date:   Sat Aug 3 23:12:00 2024 -0300

    commit 1

commit 6fb66f7321ae34694af94cff4259d8c40696a87a (origin/master)
Author: ux-pages <contato.ux.pages@gmail.com>
Date:   Sat Aug 3 23:03:51 2024 -0300

    readme

Alaiane@DESKTOP-UKVV7MO MINGW64 ~/Desktop/java (master)
$ git branch
* master
  teste

Alaiane@DESKTOP-UKVV7MO MINGW64 ~/Desktop/java (master)
$ git branch -d teste
Deleted branch teste (was 19f173b).

Alaiane@DESKTOP-UKVV7MO MINGW64 ~/Desktop/java (master)
$ git branch
* master

Alaiane@DESKTOP-UKVV7MO MINGW64 ~/Desktop/java (master)
$

