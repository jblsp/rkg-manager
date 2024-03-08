package rkgtool;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import com.formdev.flatlaf.FlatClientProperties;

import java.util.function.BiConsumer;

public class TabPane extends JTabbedPane {

    public TabPane() {
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
            }
        });
    }

    @Override
    public void removeTabAt(int index) {
        // TODO: warn user if there is unsaved work here
        super.removeTabAt(index);
    }

    public void addTab(TabbableFile s) {
        this.addTab(s.getTabName(), s.createPanel());
    }

}
