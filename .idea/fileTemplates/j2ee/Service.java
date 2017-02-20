package ${PACKAGE_NAME};

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

#parse("File Header.java")
/**
 * 作者： by zhush on ${DATE}.
 * 邮箱：zhush@jerei,com
 * 类说明：
 */
public class ${NAME} extends Service {
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}
