package synfron.reshaper.burp.ui.components.rules.thens;

import synfron.reshaper.burp.core.ProtocolType;
import synfron.reshaper.burp.core.rules.RuleResponse;
import synfron.reshaper.burp.core.rules.thens.ThenBreak;
import synfron.reshaper.burp.ui.models.rules.thens.ThenBreakModel;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class ThenBreakComponent extends ThenComponent<ThenBreakModel, ThenBreak> {
    private JComboBox<RuleResponse> breakType;

    public ThenBreakComponent(ProtocolType protocolType, ThenBreakModel then) {
        super(protocolType, then);
        initComponent();
    }

    private void initComponent() {
        breakType = createComboBox(RuleResponse.getValues().stream().skip(1).toArray(RuleResponse[]::new));

        breakType.setSelectedItem(model.getBreakType());

        breakType.addActionListener(this::onBreakTypeChanged);

        mainContainer.add(getLabeledField("Break Type", breakType), "wrap");
    }

    private void onBreakTypeChanged(ActionEvent actionEvent) {
        model.setBreakType((RuleResponse)breakType.getSelectedItem());
    }
}
