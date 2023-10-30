package practice;

import java.util.*;

public class PhoneBook {

    Set <String> phone = new TreeSet<>();
    Map <String, String> phoneBook = new TreeMap<>();

    public void addContact(String phone, String name) {
        if (phone.matches("[\\d]{11}") && name.matches("[А-Яа-я]+")) {
            if (phoneBook.containsKey(phone)) {
                phoneBook.replace(phone, phoneBook.get(phone), name);
            } else {
                phoneBook.put(phone,name);
            }
        }
        // проверьте корректность формата имени и телефона
        // (рекомедуется написать отдельные методы для проверки является строка именем/телефоном)
        // если такой номер уже есть в списке, то перезаписать имя абонента
    }

    public String getContactByPhone(String phone) {
        if (phoneBook.containsKey(phone)) {
            return phoneBook.get(phone) + " - " + phone;
        } else {
            return " ";
        }
        // формат одного контакта "Имя - Телефон"
        // если контакт не найдены - вернуть пустую строку
    }

    public Set<String> getContactByName(String name) {
        Set<String> setPhoneBook = new TreeSet<>();
        String namePlusTel = "";
        if (phoneBook.containsValue(name)) {
            namePlusTel = namePlusTel.concat(name) + " - ";
            for (String tel : phoneBook.keySet()) {
                if (phoneBook.get(tel).equals(name)) {
                    namePlusTel = namePlusTel.concat(tel) + ", ";
                }
            }
            setPhoneBook.add(namePlusTel.substring(0, namePlusTel.length() - 2));
            return setPhoneBook;
        } else {
            return new TreeSet<>();
        }
        // формат одного контакта "Имя - Телефон"
        // если контакт не найден - вернуть пустой TreeSet
    }

    public Set<String> getAllContacts() {
        Map<String, TreeSet<String>> nameToPhones = new HashMap<>();
        for (String key : phoneBook.keySet()) {
            String name = phoneBook.get(key);
            if (!nameToPhones.containsKey(name)) {
                nameToPhones.put(name, new TreeSet<>());
            }
            nameToPhones.get(name).add(key);
        }

        Set<String> result = new HashSet<>();
        for (String key : nameToPhones.keySet()) {
            String resultString = key + " - " + nameToPhones.get(key);
            result.add(resultString.replaceAll("[\\[\\]]",""));
        }

        return result;
        // формат одного контакта "Имя - Телефон"
        // если контактов нет в телефонной книге - вернуть пустой TreeSet

    }


    // для обхода Map используйте получение пары ключ->значение Map.Entry<String,String>
    // это поможет вам найти все ключи (key) по значению (value)
    /*
        for (Map.Entry<String, String> entry : map.entrySet()){
            String key = entry.getKey(); // получения ключа
            String value = entry.getValue(); // получения ключа
        }
    */
}