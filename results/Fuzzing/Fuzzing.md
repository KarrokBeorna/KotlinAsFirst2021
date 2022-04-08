Как и в прошлый раз - вставлю скрины с оценкой покрытия. Использовал библиотеку JQF.

1. Обычное случайное тестирование:

![image](https://user-images.githubusercontent.com/43076360/162510666-89e2e04b-71b0-488f-80f6-88c2853f57d0.png)

Даже сейчас уже можно заметить, насколько плохо генерируются входные данные. В прошлый раз процент покрытия строк был значительно больше, к тому же во время фаззинга bagPacking столкнулся с одной проблемой:

`java.lang.IllegalArgumentException:`  
`Cannot find generator for java.util.Map<java.lang.String, kotlin.Pair<java.lang.Integer, java.lang.Integer>>:`  
`kotlin.Pair<java.lang.Integer,java.lang.Integer> of type kotlin.Pair<java.lang.Integer, java.lang.Integer>`

Ну, раз нет генератора, то ладно :)

2. lesson5 - findSumOfTwo():

![image](https://user-images.githubusercontent.com/43076360/162511524-d4d1b886-4672-4e9e-b9b8-66b5b6d91867.png)

3. lesson6 - mostExpensive():

![image](https://user-images.githubusercontent.com/43076360/162511640-954c88bb-e766-47f1-9d6d-a35c542e6ea8.png)

4. lesson6 - fromRoman():

![image](https://user-images.githubusercontent.com/43076360/162511708-c4c6403d-7078-41c8-8d84-73f9a84102b1.png)

5. lesson7 - markdownToHtmlLists():

![image](https://user-images.githubusercontent.com/43076360/162511789-ac4af5aa-ef3a-4595-b5b1-9d520ec003e3.png)

Как мы видим, в каждой функции появились незатронутые строки, особенно это коснулось 7 урока с файлами, где у человека идёт сплит по пробелу и программа не может пройти дальше (собственно, как и говорилось на лекции, это одна из проблем такого тестирования).

Пришлось чутка доработать генерацию - изначально заполнять файл тремя символами "1. ", чтобы пройти хоть чутка глубже:

6. lesson7 - markdownToHtmlLists() после доработки генерации:

![image](https://user-images.githubusercontent.com/43076360/162513297-3ae127e7-6645-489b-a121-c4ab67748e96.png)

В целом это помогло, однако всё равно процент покрытия получился не такой, как при ручном написании тестов.

Итого: для таких простых программ легче будет писать генерацию тестов через обычный цикл с условиями и простейшим рандомом, либо усложнять себе жизнь (на легких-то вещах!), создавая более направленные генераторы тестов.
