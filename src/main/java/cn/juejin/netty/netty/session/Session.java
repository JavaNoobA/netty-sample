package cn.juejin.netty.netty.session;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author pengfei.zhao
 * @date 2021/1/3 10:23
 */
@Data
@NoArgsConstructor
public class Session {
    private String userId;
    private String userName;

    public Session(String userId, String userName) {
        this.userId = userId;
        this.userName = userName;
    }

    @Override
    public String toString(){
        return userId + ": " + userName;
    }
}
