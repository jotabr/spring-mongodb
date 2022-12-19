package br.com.jjd.sm;

import br.com.jjd.sm.adapter.out.mongo.repository.ConfigRepository;
import br.com.jjd.sm.adapter.out.mongo.repository.LevelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Main implements CommandLineRunner {

    @Autowired
    private ConfigRepository configRepository;

    @Autowired
    private LevelRepository levelRepository;

    @Override
    public void run(String... args) throws Exception {
        /*levelRepository.deleteAll();

        Random random = new Random();

        for (int i = 0 ; i < 1000; i++ ) {
            int p = random.nextInt(99);
            int s = random.nextInt(99);
            int v = random.nextInt(99);

            levelRepository.save(
                    new Level(
                            new LevelId(
                                    String.format("%02d", p),
                                    String.format("%02d", s),
                                    String.format("%02d", v)
                            ), "enable", 2));
        }


        repository.deleteAll();
        for (int i = 0 ; i < 500; i++ ) {
            int p = random.nextInt(99);
            int s = random.nextInt(99);
            int v = random.nextInt(99);

            repository.save(
                    new Config(
                            String.format("%02d", p),
                            String.format("%02d", s),
                            String.format("%02d", v),
                            "enable", 2));
        }
        repository.save(new Config("01", "02", "03", "Enable", 1));
        repository.save(new Config("01", "02", "0", "Enable", 1));

        //levelRepository.deleteAll();
        levelRepository.save(new Level(new LevelId("01", "02", "03"), "enable", 2));
        levelRepository.save(new Level(new LevelId("01", "02", "0"), "enable", 2));
        levelRepository.save(new Level(new LevelId("01", "0", "0"), "enable", 2));


        System.out.println("Founds");
        for (Config config : repository.findAll()) {
            System.out.println(config);
        }
        System.out.println();

        System.out.println("Registros no MongoDB");
        for (Level level : levelRepository.findAll()) {
            System.out.println(level);
        }
        System.out.println();*/

        System.out.println("Buscas...");
        System.out.println(">> 01 02 03 - " + levelRepository.findItemByProdutoSubProdutoAndVariacao("01", "02", "03"));
        System.out.println(">> 01 02 99 - " + levelRepository.findItemByProdutoSubProdutoAndVariacao("01", "02", "99"));
        System.out.println(">> 01 03 99 - " + levelRepository.findItemByProdutoSubProdutoAndVariacao("01", "03", "99"));
        System.out.println(">> 02 02 03 - " + levelRepository.findItemByProdutoSubProdutoAndVariacao("02", "02", "03"));
        System.out.println(">> 01 05 03 - " + levelRepository.findItemByProdutoSubProdutoAndVariacao("01", "05", "03"));

        System.out.println("Buscas...");
        System.out.println(">> 01 02 03 - " + configRepository.findItemByProdutoSubProdutoAndVariacao("01", "02", "03"));
        System.out.println(">> 01 02 99 - " + configRepository.findItemByProdutoSubProdutoAndVariacao("01", "02", "99"));
        System.out.println(">> 01 03 99 - " + configRepository.findItemByProdutoSubProdutoAndVariacao("01", "03", "99"));
        System.out.println(">> 02 02 03 - " + configRepository.findItemByProdutoSubProdutoAndVariacao("02", "02", "03"));
        System.out.println(">> 01 05 03 - " + configRepository.findItemByProdutoSubProdutoAndVariacao("01", "05", "03"));
    }

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }
}