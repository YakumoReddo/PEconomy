package ru.soknight.peconomy.command;

import ru.soknight.lib.command.preset.ModifiedDispatcher;
import ru.soknight.lib.configuration.Messages;
import ru.soknight.peconomy.PEconomy;
import ru.soknight.peconomy.command.peconomy.*;
import ru.soknight.peconomy.configuration.CurrenciesManager;
import ru.soknight.peconomy.database.DatabaseManager;
import ru.soknight.peconomy.notification.NotificationManager;

public class CommandPeconomy extends ModifiedDispatcher {
    
    public CommandPeconomy(
            PEconomy plugin,
            Messages messages,
            DatabaseManager databaseManager,
            CurrenciesManager currenciesManager,
            NotificationManager notificationManager
    ) {
        super("peconomy", messages);
        
        super.setExecutor("help", new CommandHelp(messages));
        super.setExecutor("info", new CommandInfo(plugin, messages, databaseManager, currenciesManager));
        super.setExecutor("history", new CommandHistory(plugin, messages, databaseManager, currenciesManager));
        super.setExecutor("add", new CommandAdd(messages, databaseManager, currenciesManager, notificationManager));
        super.setExecutor("set", new CommandSet(messages, databaseManager, currenciesManager));
        super.setExecutor("reset", new CommandReset(messages, databaseManager, currenciesManager));
        super.setExecutor("take", new CommandTake(messages, databaseManager, currenciesManager));
        super.setExecutor("reload", new CommandReload(plugin, messages));

        super.register(plugin, true);
    }

}