import java.util.*;

public class Main {
    private static int size;
    private static int maxValue;
    private static int treshold;

    public static void main(String[] args) {
        Logger logger = Logger.getInstance();
        logger.log("Запускаем программу");
        logger.log("Просим пользователя ввести входные данные для списка");
        Scanner sc = new Scanner(System.in);
        while (size <= 0) {
            try {
                System.out.println("Введите размер списка: ");
                size = sc.nextInt();
                logger.log("Введено число");
                if (size <= 0) {
                    logger.log("Число должно быть положительным");
                }
            } catch (InputMismatchException e) {
                logger.log("Введено не число");
                sc.nextLine();
            }
        }
        while (maxValue <= 0) {
            try {
                System.out.println("Введите верхнюю границу для значений: ");
                maxValue = sc.nextInt();
                logger.log("Введено число");
                if (maxValue <= 0) {
                    logger.log("Число должно быть положительным");
                }
            } catch (InputMismatchException e) {
                logger.log("Введено не число");
            }
        }

        logger.log("Создаем и заполняем список");
        List<Integer> list = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < size; i++) {
            list.add(random.nextInt(maxValue));
        }
        System.out.println("Вот случайный список " + list);
        logger.log("Просим пользователя ввести входные данные для фильтрации");
        while (treshold <= 0) {
            try {
                System.out.println("Введите порог для фильтра: ");
                treshold = sc.nextInt();
                logger.log("Введено число");
                if (treshold <= 0 || treshold > maxValue)
                    logger.log("Число должно быть положительным и не больше верхней границы");
            } catch (InputMismatchException e) {
                logger.log("Введено не число");
                sc.nextLine();
            }
        }
        sc.close();

        logger.log("Запускаем фильтрацию");
        Filter filter = new Filter(treshold);
        List<Integer> result = filter.filterOut(list);
        logger.log("Выводим результат на экран");
        System.out.println("Отфильтрованный список: " + result);
        logger.log("Завершаем программу");
    }
}
