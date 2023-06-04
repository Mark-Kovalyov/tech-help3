# Image magic

## With image magick

```
convert ml-in-mlstudio.png -contrast-stretch 15% -sharpen 0x.5 ml-in-mlstudio-filtered.png

convert pyspark-cheatsheet.png -contrast-stretch 15% -sharpen 0x.5 pyspark-cheatsheet-filtered.png
```

sudo apt install libvips-tools


```
convert -density 150 input.pdf -brightness-contrast 5x25 -sharpen 0x1 output.pdf

convert -density 300 input.pdf -colorspace gray -normalize -level 50%,51% -sharpen 0x1 output.pdf

convert -density 300 input.pdf -colorspace gray -normalize -level 25%,26% -sharpen 0x1 output.pdf

convert -density 300 input.pdf -colorspace gray -normalize -modulate 150 -sharpen 0x1 output.pdf

convert -density 300 input.pdf -contrast -contrast -contrast -contrast -sharpen 0x1 output.pdf

convert -density 300 input.pdf -contrast-stretch 15% -sharpen 0x.5 output.pdf

```

```
