package synfron.reshaper.burp.core.rules.thens;

import lombok.Getter;
import lombok.Setter;
import synfron.reshaper.burp.core.messages.EventInfo;
import synfron.reshaper.burp.core.rules.IHttpRuleOperation;
import synfron.reshaper.burp.core.rules.IWebSocketRuleOperation;
import synfron.reshaper.burp.core.rules.RuleOperationType;
import synfron.reshaper.burp.core.rules.RuleResponse;

public class ThenDrop extends Then<ThenDrop> implements IHttpRuleOperation, IWebSocketRuleOperation {
    @Getter @Setter
    private boolean dropMessage = true;

    public RuleResponse perform(EventInfo eventInfo) {
        eventInfo.setShouldDrop(dropMessage);
        if (eventInfo.getDiagnostics().isEnabled()) eventInfo.getDiagnostics().logValue(this, false, dropMessage);
        return RuleResponse.Continue;
    }

    @Override
    public RuleOperationType<ThenDrop> getType() {
        return ThenType.Drop;
    }
}
