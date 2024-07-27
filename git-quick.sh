#!/bin/bash

git add .
message="committed on $(date) by $(whoami) from $(hostname)"
echo "commit message = $message"
git commit -m "$message"
git push