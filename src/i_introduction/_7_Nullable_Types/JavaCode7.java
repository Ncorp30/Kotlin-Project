package i_introduction._7_Nullable_Types;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import util.JavaCode;

import java.util.Optional;

public class JavaCode7 extends JavaCode {
    public void sendMessageToClient(@Nullable Client client, @Nullable String message, @NotNull Mailer mailer) {
        Optional.ofNullable(client)
                .map(Client::getPersonalInfo)
                .map(PersonalInfo::getEmail)
                .ifPresent(email -> {
                    if (message != null) {
                        mailer.sendMessage(email, message);
                    }
                });
    }
}