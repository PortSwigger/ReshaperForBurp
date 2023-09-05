package synfron.reshaper.burp.ui.components.rules.thens;

import synfron.reshaper.burp.core.ProtocolType;
import synfron.reshaper.burp.core.rules.thens.ThenComment;
import synfron.reshaper.burp.ui.models.rules.thens.ThenCommentModel;
import synfron.reshaper.burp.ui.utils.DocumentActionListener;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class ThenCommentComponent extends ThenComponent<ThenCommentModel, ThenComment> {
    private JTextField text;

    public ThenCommentComponent(ProtocolType protocolType, ThenCommentModel then) {
        super(protocolType, then);
        initComponent();
    }

    private void initComponent() {
        text = createTextField(true);

        text.setText(model.getText());

        text.getDocument().addDocumentListener(new DocumentActionListener(this::onTextChanged));

        mainContainer.add(getLabeledField("Text *", text), "wrap");
    }

    private void onTextChanged(ActionEvent actionEvent) {
        model.setText(text.getText());
    }
}
