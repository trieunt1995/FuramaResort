package com.trieunt.Commons;

import com.opencsv.CSVWriter;
import com.opencsv.bean.ColumnPositionMappingStrategy;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import com.trieunt.Models.*;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.TreeSet;

public class ReadWriteToFile {
    private static final char DEFAULT_SEPARATOR = ',';
    private static final char DEFAULT_QUOTE = '"';
    private static final int NUM_OF_LINE_SKIP = 1;

    // Path file
    private static final String PATH_VILLA = "src/com/trieunt/Data/Villa.csv";
    private static final String PATH_HOUSE = "src/com/trieunt/Data/House.csv";
    private static final String PATH_ROOM = "src/com/trieunt/Data/Room.csv";
    private static final String PATH_CUSTOMER = "src/com/trieunt/Data/Customer.csv";
    private static final String PATH_BOOKING = "src/com/trieunt/Data/Booking.csv";

    // Header record file
    private static String[] headerRecordVilla = {"id", "serviceName", "usedArea", "costRent",
            "maximumNumberPeople", "typeRent", "roomStandard", "otherDescriptionUtility",
            "numberFloors", "poolArea"};

    private static String[] headerRecordHouse = {"id", "serviceName", "usedArea", "costRent",
            "maximumNumberPeople", "typeRent", "roomStandard", "otherDescriptionUtility",
            "numberFloors"};
    private static String[] headerRecordRoom = {"id", "serviceName", "usedArea", "costRent",
            "maximumNumberPeople", "typeRent", "serviceFree"};

    private static String[] headerRecordCustomer = {"id", "customerName", "gender", "birthday", "idCard",
            "phone", "email", "typeCustomer", "address"};

    private static String[] headerRecordBooking = {"id", "customerName", "gender", "birthday", "idCard",
            "phone", "email", "typeCustomer", "address", "id", "serviceName", "usedArea", "costRent",
            "maximumNumberPeople", "typeRent"};

    /**
     * Phương thức ghi file villa
     */
    public static void writeDataVillasToFile(ArrayList<Villa> villas) {
        try (Writer writer = new FileWriter(PATH_VILLA);

             CSVWriter csvWriter = new CSVWriter(writer,
                     CSVWriter.DEFAULT_SEPARATOR,
                     CSVWriter.NO_QUOTE_CHARACTER,
                     CSVWriter.DEFAULT_ESCAPE_CHARACTER,
                     CSVWriter.DEFAULT_LINE_END)
             )
        {
            csvWriter.writeNext(headerRecordVilla);
            for (Villa villa : villas) {
                csvWriter.writeNext(new String[] {
                        villa.getId(),
                        villa.getServiceName(),
                        Double.toString(villa.getUsedArea()),
                        Double.toString(villa.getCostRent()),
                        Integer.toString(villa.getMaximumNumberPeople()),
                        villa.getTypeRent(),
                        villa.getRoomStandard(),
                        villa.getOtherDescriptionUtility(),
                        Integer.toString(villa.getNumberFloors()),
                        Double.toString(villa.getPoolArea())
                });
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Phương thức ghi file house
     */
    public static void writeDataHousesToFile(ArrayList<House> houses) {
        try (Writer writer = new FileWriter(PATH_HOUSE);

             CSVWriter csvWriter = new CSVWriter(writer,
                     CSVWriter.DEFAULT_SEPARATOR,
                     CSVWriter.NO_QUOTE_CHARACTER,
                     CSVWriter.DEFAULT_ESCAPE_CHARACTER,
                     CSVWriter.DEFAULT_LINE_END)
        )
        {
            csvWriter.writeNext(headerRecordHouse);
            for (House house : houses) {
                csvWriter.writeNext(new String[] {
                        house.getId(),
                        house.getServiceName(),
                        Double.toString(house.getUsedArea()),
                        Double.toString(house.getCostRent()),
                        Integer.toString(house.getMaximumNumberPeople()),
                        house.getTypeRent(),
                        house.getRoomStandard(),
                        house.getOtherDescriptionUtility(),
                        Integer.toString(house.getNumberFloors())
                });
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Phương thức ghi file room
     */
    public static void writeDataRoomsToFile(ArrayList<Room> rooms) {
        try (Writer writer = new FileWriter(PATH_ROOM);

             CSVWriter csvWriter = new CSVWriter(writer,
                     CSVWriter.DEFAULT_SEPARATOR,
                     CSVWriter.NO_QUOTE_CHARACTER,
                     CSVWriter.DEFAULT_ESCAPE_CHARACTER,
                     CSVWriter.DEFAULT_LINE_END)
        )
        {
            csvWriter.writeNext(headerRecordRoom);
            for (Room room : rooms) {
                csvWriter.writeNext(new String[] {
                        room.getId(),
                        room.getServiceName(),
                        Double.toString(room.getUsedArea()),
                        Double.toString(room.getCostRent()),
                        Integer.toString(room.getMaximumNumberPeople()),
                        room.getTypeRent(),
                        room.getServiceFree()
                });
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Phương thức ghi file customer
     */
    public static void writeDataCustomersToFile(ArrayList<Customer> customers) {
        try (Writer writer = new FileWriter(PATH_CUSTOMER);

             CSVWriter csvWriter = new CSVWriter(writer,
                     CSVWriter.DEFAULT_SEPARATOR,
                     CSVWriter.NO_QUOTE_CHARACTER,
                     CSVWriter.DEFAULT_ESCAPE_CHARACTER,
                     CSVWriter.DEFAULT_LINE_END)
        )
        {
            csvWriter.writeNext(headerRecordCustomer);
            for (Customer customer : customers) {
                csvWriter.writeNext(new String[] {
                        customer.getId(),
                        customer.getCustomerName(),
                        customer.getGender(),
                        customer.getBirthday(),
                        customer.getIdCard(),
                        customer.getPhone(),
                        customer.getEmail(),
                        customer.getTypeCustomer(),
                        customer.getAddress()
                });
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Phương thức ghi file booking
     * @param customers
     */
    public static void writeDataBookingsToFile(ArrayList<Customer> bookingList) {
        try (Writer writer = new FileWriter(PATH_BOOKING);

             CSVWriter csvWriter = new CSVWriter(writer,
                     CSVWriter.DEFAULT_SEPARATOR,
                     CSVWriter.NO_QUOTE_CHARACTER,
                     CSVWriter.DEFAULT_ESCAPE_CHARACTER,
                     CSVWriter.DEFAULT_LINE_END)
        )
        {
            csvWriter.writeNext(headerRecordBooking);
            for (Customer customer : bookingList) {
                csvWriter.writeNext(new String[] {
                        customer.getId(),
                        customer.getCustomerName(),
                        customer.getGender(),
                        customer.getBirthday(),
                        customer.getIdCard(),
                        customer.getPhone(),
                        customer.getEmail(),
                        customer.getTypeCustomer(),
                        customer.getAddress(),
                        customer.getService().getId(),
                        customer.getService().getServiceName(),
                        String.valueOf(customer.getService().getUsedArea()),
                        Double.toString(customer.getService().getCostRent()),
                        Integer.toString(customer.getService().getMaximumNumberPeople()),
                        customer.getService().getTypeRent()
                });
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Phương thức đọc file Villa
     */
    public static ArrayList<Villa> readDataVillasToFile() {
        Path path = Paths.get(PATH_VILLA);
        checkFile(PATH_VILLA, path);

        ColumnPositionMappingStrategy<Villa> columnPositionMappingStrategy = new ColumnPositionMappingStrategy<>();
        columnPositionMappingStrategy.setType(Villa.class);
        columnPositionMappingStrategy.setColumnMapping(headerRecordVilla);

        CsvToBean csvToBean = null;
        try {
            csvToBean = new CsvToBeanBuilder<Villa>(new FileReader(PATH_VILLA))
                    .withMappingStrategy(columnPositionMappingStrategy)
                    .withSeparator(DEFAULT_SEPARATOR)
                    .withQuoteChar(DEFAULT_QUOTE)
                    .withSkipLines(NUM_OF_LINE_SKIP)
                    .withIgnoreLeadingWhiteSpace(true)
                    .build();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return (ArrayList<Villa>)csvToBean.parse();
    }

    /**
     * Phương thức đọc file house
     */
    public static ArrayList<House> readDataHousesToFile() {
        Path path = Paths.get(PATH_HOUSE);
        checkFile(PATH_HOUSE, path);

        ColumnPositionMappingStrategy<House> columnPositionMappingStrategy = new ColumnPositionMappingStrategy<>();
        columnPositionMappingStrategy.setType(House.class);
        columnPositionMappingStrategy.setColumnMapping(headerRecordHouse);

        CsvToBean csvToBean = null;
        try {
            csvToBean = new CsvToBeanBuilder<House>(new FileReader(PATH_HOUSE))
                    .withMappingStrategy(columnPositionMappingStrategy)
                    .withSeparator(DEFAULT_SEPARATOR)
                    .withQuoteChar(DEFAULT_QUOTE)
                    .withSkipLines(NUM_OF_LINE_SKIP)
                    .withIgnoreLeadingWhiteSpace(true)
                    .build();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return (ArrayList<House>)csvToBean.parse();
    }

    /**
     * Phương thức đọc file room
     */
    public static ArrayList<Room> readDataRoomsToFile() {
        Path path = Paths.get(PATH_ROOM);
        checkFile(PATH_ROOM, path);

        ColumnPositionMappingStrategy<Room> columnPositionMappingStrategy = new ColumnPositionMappingStrategy<>();
        columnPositionMappingStrategy.setType(Room.class);
        columnPositionMappingStrategy.setColumnMapping(headerRecordRoom);

        CsvToBean csvToBean = null;
        try {
            csvToBean = new CsvToBeanBuilder<Room>(new FileReader(PATH_ROOM))
                    .withMappingStrategy(columnPositionMappingStrategy)
                    .withSeparator(DEFAULT_SEPARATOR)
                    .withQuoteChar(DEFAULT_QUOTE)
                    .withSkipLines(NUM_OF_LINE_SKIP)
                    .withIgnoreLeadingWhiteSpace(true)
                    .build();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return (ArrayList<Room>)csvToBean.parse();
    }

    /**
     * Phương thức đọc file customer
     */
    public static ArrayList<Customer> readDataCustomersToFile() {
        Path path = Paths.get(PATH_CUSTOMER);
        checkFile(PATH_CUSTOMER, path);

        ColumnPositionMappingStrategy<Customer> columnPositionMappingStrategy = new ColumnPositionMappingStrategy<>();
        columnPositionMappingStrategy.setType(Customer.class);
        columnPositionMappingStrategy.setColumnMapping(headerRecordCustomer);

        CsvToBean csvToBean = null;
        try {
            csvToBean = new CsvToBeanBuilder<Customer>(new FileReader(PATH_CUSTOMER))
                    .withMappingStrategy(columnPositionMappingStrategy)
                    .withSeparator(DEFAULT_SEPARATOR)
                    .withQuoteChar(DEFAULT_QUOTE)
                    .withSkipLines(NUM_OF_LINE_SKIP)
                    .withIgnoreLeadingWhiteSpace(true)
                    .build();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return (ArrayList<Customer>)csvToBean.parse();
    }

    public static ArrayList<Customer> readDataBookingsToFile() {
        Path path = Paths.get(PATH_BOOKING);
        checkFile(PATH_CUSTOMER, path);

        ColumnPositionMappingStrategy<Customer> columnPositionMappingStrategy = new ColumnPositionMappingStrategy<>();
        columnPositionMappingStrategy.setType(Customer.class);
        columnPositionMappingStrategy.setColumnMapping(headerRecordBooking);

        CsvToBean csvToBean = null;
        try {
            csvToBean = new CsvToBeanBuilder<Customer>(new FileReader(PATH_BOOKING))
                    .withMappingStrategy(columnPositionMappingStrategy)
                    .withSeparator(DEFAULT_SEPARATOR)
                    .withQuoteChar(DEFAULT_QUOTE)
                    .withSkipLines(NUM_OF_LINE_SKIP)
                    .withIgnoreLeadingWhiteSpace(true)
                    .build();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return (ArrayList<Customer>)csvToBean.parse();
    }

    /**
     * Phương thức đọc file booking
     */
    public static ArrayList<Customer> readDataVillasBookingsToFile() {
        ArrayList<Customer> listArrCustomer = new ArrayList<Customer>();
        BufferedReader bufferedReader = null;
        try {
            String line;
            bufferedReader = new BufferedReader(new FileReader(PATH_BOOKING));

            while ((line = bufferedReader.readLine()) != null) {
                Customer customer = new Customer();
                Villa villa = new Villa();
                String[] dataSplit = line.split(",");
                if (dataSplit[0].equals("id")){
                    continue;
                }
                customer.setId(dataSplit[0]) ;
                customer.setCustomerName(dataSplit[1]);
                customer.setGender(dataSplit[2]);
                customer.setBirthday(dataSplit[3]);
                customer.setIdCard(dataSplit[4]);
                customer.setPhone(dataSplit[5]);
                customer.setEmail(dataSplit[6]);
                customer.setTypeCustomer(dataSplit[7]);
                customer.setAddress(dataSplit[8]);
                villa.setId(dataSplit[9]);
                villa.setServiceName(dataSplit[10]);
                villa.setUsedArea(Double.parseDouble(dataSplit[11]));
                villa.setCostRent(Double.parseDouble(dataSplit[12]));
                villa.setMaximumNumberPeople(Integer.parseInt(dataSplit[13]));
                listArrCustomer.add(customer);
                customer.setService(villa);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (bufferedReader != null)
                    bufferedReader.close();
            } catch (IOException ioe) {
                ioe.printStackTrace();
            }
        }
        return listArrCustomer;
    }

    public static ArrayList<Customer> readDataHouseBookingsToFile() {
        ArrayList<Customer> listArrCustomer = new ArrayList<Customer>();
        BufferedReader bufferedReader = null;
        try {
            String line;
            bufferedReader = new BufferedReader(new FileReader(PATH_BOOKING));

            while ((line = bufferedReader.readLine()) != null) {
                Customer customer = new Customer();
                House house = new House();
                String[] dataSplit = line.split(",");
                if (dataSplit[0].equals("id")){
                    continue;
                }
                customer.setId(dataSplit[0]) ;
                customer.setCustomerName(dataSplit[1]);
                customer.setGender(dataSplit[2]);
                customer.setBirthday(dataSplit[3]);
                customer.setIdCard(dataSplit[4]);
                customer.setPhone(dataSplit[5]);
                customer.setEmail(dataSplit[6]);
                customer.setTypeCustomer(dataSplit[7]);
                customer.setAddress(dataSplit[8]);
                house.setId(dataSplit[9]);
                house.setServiceName(dataSplit[10]);
                house.setUsedArea(Double.parseDouble(dataSplit[11]));
                house.setCostRent(Double.parseDouble(dataSplit[12]));
                house.setMaximumNumberPeople(Integer.parseInt(dataSplit[13]));
                listArrCustomer.add(customer);
                customer.setService(house);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (bufferedReader != null)
                    bufferedReader.close();
            } catch (IOException ioe) {
                ioe.printStackTrace();
            }
        }
        return listArrCustomer;
    }

    public static ArrayList<Customer> readDataRoomBookingsToFile() {
        ArrayList<Customer> listArrCustomer = new ArrayList<Customer>();
        BufferedReader bufferedReader = null;
        try {
            String line;
            bufferedReader = new BufferedReader(new FileReader(PATH_BOOKING));

            while ((line = bufferedReader.readLine()) != null) {
                Customer customer = new Customer();
                Room room = new Room();
                String[] dataSplit = line.split(",");
                if (dataSplit[0].equals("id")){
                    continue;
                }
                customer.setId(dataSplit[0]) ;
                customer.setCustomerName(dataSplit[1]);
                customer.setGender(dataSplit[2]);
                customer.setBirthday(dataSplit[3]);
                customer.setIdCard(dataSplit[4]);
                customer.setPhone(dataSplit[5]);
                customer.setEmail(dataSplit[6]);
                customer.setTypeCustomer(dataSplit[7]);
                customer.setAddress(dataSplit[8]);
                room.setId(dataSplit[9]);
                room.setServiceName(dataSplit[10]);
                room.setUsedArea(Double.parseDouble(dataSplit[11]));
                room.setCostRent(Double.parseDouble(dataSplit[12]));
                room.setMaximumNumberPeople(Integer.parseInt(dataSplit[13]));
                listArrCustomer.add(customer);
                customer.setService(room);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (bufferedReader != null)
                    bufferedReader.close();
            } catch (IOException ioe) {
                ioe.printStackTrace();
            }
        }
        return listArrCustomer;
    }

    /**
     * Phương thức kiểm tra file có tồn tại hay không?
     */
    public static void checkFile(String path, Path pathFile) {
        if (!Files.exists(pathFile)) {
            try  {
                Writer writer = new FileWriter(path);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static String getNameServiceFromFile(String csvLine) {
        String name = "";
        if (csvLine != null) {
            String[] splitData = csvLine.split(",");
            name = splitData[1];
        }
        return name;
    }

    public static TreeSet<String> readNameServicesToFile(String path) {
        BufferedReader bufferedReader = null;
        TreeSet<String> result = new TreeSet<String>();

        try {
            String line;
            bufferedReader = new BufferedReader(new FileReader(path));
            while (bufferedReader.readLine()!=null){
                line = bufferedReader.readLine();
                if (getNameServiceFromFile(line).equals("serviceName")){
                    continue;
                }
                result.add(getNameServiceFromFile(line));
            };
        }  catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }


}
