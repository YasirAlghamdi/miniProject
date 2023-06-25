package com.example.demo.csv;

import com.example.demo.game.Game;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class CSVHelper {
    public static String TYPE = "text/csv";

    public static boolean hasCSVFormat(MultipartFile file) {

        return TYPE.equals( file.getContentType() );
    }

    public static List<Game> csvToTutorials(InputStream is) {
        try (BufferedReader fileReader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
             CSVParser csvParser = new CSVParser(fileReader,
                     CSVFormat.DEFAULT.withFirstRecordAsHeader().withIgnoreHeaderCase().withTrim());) {

            List<Game> games = new ArrayList<Game>();

            Iterable<CSVRecord> csvRecords = csvParser.getRecords();

            for (CSVRecord csvRecord : csvRecords) {
                Game game = new Game(
                        csvRecord.get("name"),
                        csvRecord.get( "developers" ),
                        csvRecord.get( "genres" ),
                        csvRecord.get( "platforms" ),
                        Integer.parseInt(csvRecord.get( "metacritic" )),
                        Date.valueOf(csvRecord.get( "released" )),
                        Integer.parseInt(csvRecord.get( "playtime" ))
                );

                games.add( game );
            }

            return games;
        } catch (IOException e) {
            throw new RuntimeException("fail to parse CSV file: " + e.getMessage());
        }
    }


}