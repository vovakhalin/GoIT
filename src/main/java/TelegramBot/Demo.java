package TelegramBot;

import TelegramBot.Responce.PrivatBankResponceApiDto;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

import java.util.List;

import static TelegramBot.Client.PrivetClient.getDefaultCurrency;

public class Demo {
    public static void main(String[] args) throws TelegramApiException {
        TelegramBotsApi botsApi = new TelegramBotsApi(DefaultBotSession.class);
        botsApi.registerBot(new MyBot());


        getDefaultCurrency();
    }
}
