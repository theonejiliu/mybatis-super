package panels;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
//TabbedContentImpl
public class SuperPanel extends JTabbedPane {
    private JTextArea area;
    private JPanel myBatis;
    private Path path = Paths.get(System.getProperty("user.home"), ".superbatis");
    private String content;

    public SuperPanel() {
        this.myBatis = new JPanel();
        area = new JTextArea();
        area.setLineWrap(true);
        area.setWrapStyleWord(true);
        JScrollPane text = new JScrollPane(area);
        text.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
//        area.setText("达到觉得卡号贷记卡圣诞节卡号看黄金卡河大街季后赛开打数据库设计大赛客户贷款达到觉得卡号贷记卡圣诞节卡号看黄金卡河大街季后赛开打数据库设计大赛客户贷款达到觉得卡号贷记卡圣诞节卡号看黄金卡河大街季后赛开打数据库设计大赛客户贷款达到觉得卡号贷记卡圣诞节卡号看黄金卡河大街季后赛开打数据库设计大赛客户贷款");
//        this.text.add(area,BorderLayout.CENTER);
        this.addTab("备忘录", text);
        this.addTab("MyBatis", this.myBatis);

        try {
            this.content = this.read(path);
            if (this.content != null && this.content.trim() != "")
                this.area.setText(content);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "读取", "失败", JOptionPane.ERROR_MESSAGE);
        }
        this.area.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.isControlDown() && e.getKeyCode() == KeyEvent.VK_S) {
                    try {
                        save();
                        JOptionPane.showMessageDialog(null, "保存", "成功", JOptionPane.INFORMATION_MESSAGE);
                    } catch (IOException e1) {
                        JOptionPane.showMessageDialog(null, "保存", "失败", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        });
    }

    public void save() throws IOException {
        if (Files.notExists(path) || Files.isDirectory(path)) {
            Files.deleteIfExists(path);
            Files.createFile(path);
        }
        if (this.content != null && !this.area.getText().equals(this.content))
            Files.write(path, area.getText().getBytes(StandardCharsets.UTF_8));
    }

    private String read(Path path) throws IOException {
        if (Files.notExists(path) || Files.isDirectory(path)) {
            Files.deleteIfExists(path);
            Files.createFile(path);
            return "";
        }
        return new String(Files.readAllBytes(path), StandardCharsets.UTF_8);
    }
}
