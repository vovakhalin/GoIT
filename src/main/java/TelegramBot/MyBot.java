package TelegramBot;

import lombok.SneakyThrows;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.MessageEntity;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static TelegramBot.BotConstants.BOT_NAME;
import static TelegramBot.BotConstants.BOT_TOKEN;
import static TelegramBot.Client.PrivetClient.currency;

public class MyBot extends TelegramLongPollingBot {



    @Override
    public void onUpdateReceived(Update update) {
//        SendMessage message = new SendMessage();
//        String chatId = update.getMessage().getChatId().toString();
//        message.setChatId(chatId);

        if (update.hasMessage()) {
            handleMessage(update.getMessage());
        }
    }
@SneakyThrows
    private void handleMessage(Message message) {
        if(message.hasText() && message.hasEntities()) {
            Optional<MessageEntity> commandEntity =
                    message.getEntities().stream().filter(e -> "bot_command".equals(e.getType())).findFirst();
            String command = null;
            if (commandEntity.isPresent()) {
                command = message.getText().substring(commandEntity.get().getOffset(), commandEntity.get().getLength());
            }
            switch (command) {
                case "/choose_the_bank":
                    List<List<InlineKeyboardMarkup>> buttom = new ArrayList<>();
                    execute(
                       SendMessage.builder()
                            .text(currency.getFirst().getBuy())
                            .chatId(message.getChatId().toString())
                               .replyMarkup(InlineKeyboardMarkup.builder().build())
                            .build());
                    return;
            }
        }
    }

    @Override
    public String getBotUsername() {
        return BOT_NAME;
    }
    @Override
    public String getBotToken() {
        return BOT_TOKEN;
    }
}
