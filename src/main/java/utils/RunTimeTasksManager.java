package utils;

import lombok.NoArgsConstructor;

import java.io.IOException;
import java.util.List;

@NoArgsConstructor
public class RunTimeTasksManager {

    public static void killTasks(List<String> tasks) throws InterruptedException, IOException {
        for (String task : tasks) {
            Runtime runTime = Runtime.getRuntime();
            Process runTimeProcess = runTime.exec(task);
            runTimeProcess.waitFor();
            runTimeProcess.destroy();
        }
    }
}
