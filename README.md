# Bar

После тщательного планирования Яндекс решил запустить новый сервис  — Яндекс.Бар. В Баре будет большой выбор слоистых коктейлей. Для удобства посетителей эти коктейли надо нарисовать в меню. Для поддержания концепции IT-бара, коктейли будут нарисованы как ASCII-арт. Вам поручили печатать рисунки, зная форму стакана, список ингредиентов и их порядок.
Форма стакана описывается символьным полем из n строк по m символов в каждой. Поле может содержать только . (точки), \ (обратные слэши), / (прямые слэши), | (вертикальные черты), _ (нижние подчеркивания) и пробелы. Дно стакана расположено на последней n-й строке и состоит из символов _ (нижних подчеркиваний), расположенных слитно. Слева и справа от дна расположено начало граней стакана. Грань – это «ломаная» из символов \ (обратных слэшей), / (прямых слэшей), | (вертикальных черт). Каждая грань содержит ровно из n символов  — по 1 символу в каждой строке. Для любой пары соседних строк i и i+1 символы грани расположены в одном или соседних столбцах. Грани не имеют пересечений или касаний ни по стороне, ни по углу. Исходя из этого, несложно показать, что любая строка кроме 
n-й имеет пустое место между двумя гранями, обозначаемое пробелами.
Фон изображения стакана состоит из символов . (точек)  — все остальное пространство (расположенно слева от левой грани стакана и справа от правой).

Формат ввода
Первая строка содержит два числа n и m, которые обозначают размеры поля – изображения стакана.
Следующие n строк по m символов в каждой содержат описание стакана в формате, указанном выше.
Следующая строка содержит число k – количество ингредиентов коктейля.
Следующие k строк содержат описания ингредиентов, по одному в каждой строке. Описание имеет вид namei counti symboli.
namei – это название i-го ингредиента (строка из строчных латинских букв длиной не менее 1 и не более 10).
counti – это количество слоев i-го ингредиента.
symboli – это символ, которым i-й ингредиент должен быть представлен в изображении (любой символ с ASCII кодом больше 32 и меньше 127, кроме тех, которые используются в описании изображения стакана).
Гарантируется, что сумма всех counti не превосходит высоты стакана, то есть n−1. Также гарантируется что все символы symboli уникальны.

Формат вывода
В n строках по m символов в каждой выведите описание стакана в указанном выше формате.
Пример 1
Ввод
```
8 15
\             /
.|           |.
.|           |.
..\         /..
...|       |...
...|       |...
....\     /....
.....\___/.....
2
gin 2 %
tonic 4 *

Вывод
\             /
.|***********|.
.|***********|.
..\*********/..
...|*******|...
...|%%%%%%%|...
....\%%%%%/....
.....\___/.....
```

![Screenshot 2023-03-31 112352](https://user-images.githubusercontent.com/106293807/229022299-96b35ac2-07cb-46c2-bd4e-168070a6bc7c.png)

