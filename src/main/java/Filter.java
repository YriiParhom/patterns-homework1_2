import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Filter {
    protected int treshold;

    public Filter(int treshold) {
        this.treshold = treshold;
    }

    public List<Integer> filterOut(List<Integer> source) {
        Logger logger = Logger.getInstance();
        List<Integer> result = new ArrayList<>();
        int a = 0;
        for (int i : source) {
            if (i >= treshold) {
                logger.log("Элемент " + i + " проходит");
                result.add(i);
                a++;
            } else logger.log("Элемент " + i + " не проходит");
        }
        logger.log("Прошло фильтр " + a + " элемента из " + source.size());
        return result;
    }
}
