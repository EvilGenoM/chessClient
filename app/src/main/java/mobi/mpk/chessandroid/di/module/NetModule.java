package mobi.mpk.chessandroid.di.module;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import mobi.mpk.chessandroid.net.WebSocketConnection;
import mobi.mpk.chessandroid.net.listener.client.ClientWebSocketListener;
import mobi.mpk.chessandroid.net.listener.client.DefaultClientWebSocketListener;

@Module
public class NetModule {

    @Provides
    @Singleton
    public WebSocketConnection provideWebSocketConnection() {
        return new WebSocketConnection();
    }

    @Provides
    @Singleton
    public ClientWebSocketListener provideClientWebSocketListener(WebSocketConnection connection) {
        return new DefaultClientWebSocketListener(connection);
    }

}
