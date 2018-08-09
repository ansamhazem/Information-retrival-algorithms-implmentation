
package invertedIndex;

import java.io.IOException;

/**
 * @author Ahmed.Taher
 */

public class IR_Task2 {

    public static void main(String[] args) throws IOException {
        Task2 T = new Task2();
        T.ReadDoc("E:\\collage\\4th year\\1st semester\\IR\\IR models\\Boolean try1\\Boolean try1\\files\\D1.txt", 1);
        T.ReadDoc("E:\\collage\\4th year\\1st semester\\IR\\IR models\\Boolean try1\\Boolean try1\\files\\D2.txt", 2);
        T.ReadDoc("E:\\collage\\4th year\\1st semester\\IR\\IR models\\Boolean try1\\Boolean try1\\files\\D3.txt", 3);
        T.ReadDoc("E:\\collage\\4th year\\1st semester\\IR\\IR models\\Boolean try1\\Boolean try1\\files\\D4.txt", 4);
        T.AfterRead();

        Output2 Query = new Output2(T);
        Query.QueryEdits("Comput&*er ahmed");

        for (int i = 0; i < Query.FinalOutput.size(); i++) {
            System.out.println(Query.FinalOutput.get(i));
        }
        System.out.println("************************");
        /// de beb2a feha el Intersection
        System.out.println(Query.set);
    }

}

