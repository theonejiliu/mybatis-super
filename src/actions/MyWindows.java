package actions;

import com.intellij.openapi.project.Project;
import com.intellij.openapi.wm.impl.ToolWindowHeadlessManagerImpl;
import org.jetbrains.annotations.NotNull;

public class MyWindows extends ToolWindowHeadlessManagerImpl.MockToolWindow {
    public MyWindows(@NotNull Project project) {
        super(project);
    }
}
