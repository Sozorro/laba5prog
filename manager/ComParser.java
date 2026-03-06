package manager;

import java.util.HashMap;
import com.*;

import exeptions.WrongParam;

public class ComParser {
    private HashMap<String, Command> commands = new HashMap<>();
    public ComParser(CollectionManeger collectionManeger) {
        commands.put("AddCom", new AddCom(collectionManeger));
        commands.put("ClearCom", new ClearCom(collectionManeger));
        commands.put("ExecuteScriptCom", new ExecuteScriptCom(collectionManeger));
        commands.put("ExitCom", new ExitCom(collectionManeger));
        commands.put("HelpCom", new HelpCom(collectionManeger));
        commands.put("HistoryCom", new HistoryCom(collectionManeger));
        commands.put("InfoCom", new InfoCom(collectionManeger));
        commands.put("RemoveCom", new RemoveCom(collectionManeger));
        commands.put("SaveCom", new SaveCom(collectionManeger));
        commands.put("ShowCom", new ShowCom(collectionManeger));
        commands.put("UpdateCom", new UpdateCom(collectionManeger));

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
