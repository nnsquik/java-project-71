[![Actions Status](https://github.com/nesquikpro/java-project-71/actions/workflows/hexlet-check.yml/badge.svg)](https://github.com/nesquikpro/java-project-71/actions)
[![Java CI](https://github.com/nnsquik/java-project-71/actions/workflows/ci.yml/badge.svg)](https://github.com/nnsquik/java-project-71/actions/workflows/ci.yml)
[![Maintainability Rating](https://sonarcloud.io/api/project_badges/measure?project=nnsquik_java-project-71&metric=sqale_rating)](https://sonarcloud.io/summary/new_code?id=nnsquik_java-project-71)
[![Coverage](https://sonarcloud.io/api/project_badges/measure?project=nnsquik_java-project-71&metric=coverage)](https://sonarcloud.io/summary/new_code?id=nnsquik_java-project-71)

# Gendiff

## Description
A CLI utility that compares two configuration files and shows a difference.

## Installation
```bash
git clone https://github.com/nnsquik/java-project-71.git
cd java-project-71
./gradlew installDist
```

# Make commands
```bash
make build                    # сборка проекта
make run-dist                 # запуск приложения
make diff-json                # запуск с тестовыми JSON файлами
make diff-yml                 # запуск с тестовыми YAML файлами
make diff-nested-json         # запуск с вложенными JSON файлами
make diff-nested-yml          # запуск с вложенными YAML файлами
make diff-plain               # запуск в plain формате
make diff-json-format         # запуск в json формате
```

## Example: diff-json
[![asciicast](https://asciinema.org/a/hBiexbkxsw3vXU26.svg)](https://asciinema.org/a/hBiexbkxsw3vXU26)

## Example: diff-yml
[![asciicast](https://asciinema.org/a/Uvc3ftQDJPQ1xQbk.svg)](https://asciinema.org/a/Uvc3ftQDJPQ1xQbk)

## Example: diff-nested-yml, diff-nested-json
[![asciicast](https://asciinema.org/a/Tq5Wd5JSsC8oLmBc.svg)](https://asciinema.org/a/Tq5Wd5JSsC8oLmBc)

## Example: diff-plain
[![asciicast](https://asciinema.org/a/bYovXjwvEUG0FTVQ.svg)](https://asciinema.org/a/bYovXjwvEUG0FTVQ)

## Example: diff-json-format
[![asciicast](https://asciinema.org/a/KaottqiwZwa76Z5T.svg)](https://asciinema.org/a/KaottqiwZwa76Z5T)