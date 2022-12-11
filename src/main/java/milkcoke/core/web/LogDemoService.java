package milkcoke.core.web;

import lombok.RequiredArgsConstructor;
import milkcoke.core.common.MyLogger;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LogDemoService implements LogService {
    private final ObjectProvider<MyLogger> myLoggerProvider;

    @Override
    public void logging(String testId) {
        var myLogger = myLoggerProvider.getObject();
        myLogger.logging("service ID : " + testId);
    }
}
