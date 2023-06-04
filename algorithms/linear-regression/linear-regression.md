# Linear regression

Formula:
<img src="https://render.githubusercontent.com/render/math?math=y=m*x%2BC">

```
SELECT
  x, AVG(x) OVER() as x_bar,
  y, AVG(y) OVER() as y_bar,
FROM tab;
```
