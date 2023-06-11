# Git :: revert illegal commit as of email

```bash
git config core.autocrlf input
git reset --soft 6e7d530d00bdbf02964e03a42b8c3273b3ba0790
git config user.email "admin@gmail.com"
git commit -m "..."
git push 
```
