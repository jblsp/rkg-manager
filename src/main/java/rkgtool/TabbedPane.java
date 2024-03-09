package rkgtool;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import com.formdev.flatlaf.FlatClientProperties;

import java.util.function.BiConsumer;

public class TabbedPane extends JTabbedPane {

    public TabbedPane() {
        this.putClientProperty(FlatClientProperties.TABBED_PANE_MAXIMUM_TAB_WIDTH, 200);
        this.putClientProperty(FlatClientProperties.TABBED_PANE_TAB_CLOSABLE, true);
        this.putClientProperty(FlatClientProperties.TABBED_PANE_TAB_CLOSE_CALLBACK,
                (BiConsumer<JTabbedPane, Integer>) (tab_pane, tab_index) -> {
                    this.removeTabAt(tab_index);
                });

        this.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                RKGTool.base_frame.menu_bar.updateMenubarOptions();
                if (TabbedPane.this.getComponentCount() > 0
                        && !(RKGTool.base_frame.getContentPane() instanceof TabbedPane)) {
                    RKGTool.base_frame.setContentPane(RKGTool.base_frame.tabbed_pane);
                }
            }
        });
    }

    @Override
    public void removeTabAt(int index) {
        // TODO: warn user if there is unsaved work here
        super.removeTabAt(index);
        if (this.getComponentCount() == 0) {
            RKGTool.base_frame.setContentPane(RKGTool.base_frame.base_panel);
        }
    }

    public void addTab(TabbableFile s) {
        this.addTab(s.getFile().getName(), s.createPanel());
    }

}
