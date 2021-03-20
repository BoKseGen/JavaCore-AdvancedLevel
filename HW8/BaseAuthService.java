import java.util.ArrayList;
import java.util.List;

public class BaseAuthService implements AuthService{
    private class Entry{
        private String login;
        private String password;
        private String nickName;

        public Entry(String login, String password, String nickName){
            this.login = login;
            this.password = password;
            this.nickName = nickName;
        }
    }
    private List<Entry> entries;

    @Override
    public void start() {
        System.out.println("Сервис аутентификации запущен");
    }

    @Override
    public void stop() {
        System.out.println("Сервис аутентификации остановлен");
    }


    public BaseAuthService() {
        entries = new ArrayList<>();
        entries.add(new Entry("login1", "pass1", "nick1"));
        entries.add(new Entry("login2", "pass2", "nick2"));
        entries.add(new Entry("login3", "pass3", "nick3"));
    }

    @Override
    public String getNickByLoginPassword(String login, String pass) {
        for (Entry entry : entries) {
            if (entry.login.equals(login) && entry.password.equals(pass)) return entry.nickName;
        }
        return null;
    }

}
