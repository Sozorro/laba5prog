package managers;

import java.util.HashMap;
import com.*;

import exeptions.WrongParam;

public class ComParser {
    private HashMap<String, Command> commands = new HashMap<>();
    public ComParser(CollectionManager collectionManager) {
        commands.put("AddCom", new AddCom(collectionManager));
        commands.put("ClearCom", new ClearCom(collectionManager));
        commands.put("ExecuteScriptCom", new ExecuteScriptCom(collectionManager));
        commands.put("ExitCom", new ExitCom(collectionManager));
        commands.put("HelpCom", new HelpCom(collectionManager));
        commands.put("HistoryCom", new HistoryCom(collectionManager));
        commands.put("InfoCom", new InfoCom(collectionManager));
        commands.put("RemoveCom", new RemoveCom(collectionManager));
        commands.put("SaveCom", new SaveCom(collectionManager));
        commands.put("ShowCom", new ShowCom(collectionManager));
        commands.put("UpdateCom", new UpdateCom(collectionManager));

    }

    public HashMap<String, Command> getCommands() {
        return commands;
    }

    public void interpret(String name, String... args) {
        Command command = this.commands.get(name);
        if (command == null) {
            throw new WrongParam("Неверная команда, проверьте корректность ввода");
        }
        else {
            command.execute(args);
        }
    }
    
}
