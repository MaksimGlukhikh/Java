import java.util.*;

public class Notebook {
    private String model;
    private int ram;
    private int storage;
    private String os;
    private String color;

    public Notebook(String model, int ram, int storage, String os, String color) {
        this.model = model;
        this.ram = ram;
        this.storage = storage;
        this.os = os;
        this.color = color;
    }

    public String getModel() {
        return model;
    }

    public int getRam() {
        return ram;
    }

    public int getStorage() {
        return storage;
    }

    public String getOs() {
        return os;
    }

    public String getColor() {
        return color;
    }

    public static void main(String[] args) {
        Set<Notebook> notebooks = new HashSet<>();
        notebooks.add(new Notebook("Notebook1", 8, 512, "Windows 10", "Black"));
        notebooks.add(new Notebook("Notebook2", 16, 1024, "Windows 7", "Silver"));
        notebooks.add(new Notebook("Notebook3", 4, 1024, "Windows 7", "White"));
        notebooks.add(new Notebook("Notebook4", 32, 512, "MacOS", "Silver"));
        notebooks.add(new Notebook("Notebook5", 16, 1024, "Minty", "Red"));

        Map<String, String> filterCriterion = new HashMap<>();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите номер критерия фильтрации:");
        System.out.println("1 - ОЗУ");
        System.out.println("2 - Объем ЖД");
        System.out.println("3 - Операционная система");
        System.out.println("4 - Цвет");
        String criterionNumber = scanner.nextLine();

        System.out.println("Введите минимальное значение для выбранного критерия:");
        String criterionValue = scanner.nextLine();

        filterCriterion.put(criterionNumber, criterionValue);

        samplingPrintNotebooks(notebooks, filterCriterion);
    }

    public static void samplingPrintNotebooks(Set<Notebook> notebooks, Map<String, String> filterCriterion) {
        for (Notebook notebook : notebooks) {
            boolean passFilter = true;

            for (Map.Entry<String, String> entry : filterCriterion.entrySet()) {
                String criterionNumber = entry.getKey();
                String criterionValue = entry.getValue();

                switch (criterionNumber) {
                    case "1": // ОЗУ
                        if (notebook.getRam() < Integer.parseInt(criterionValue)) {
                            passFilter = false;
                        }
                        break;
                    case "2": // Объем ЖД
                        if (notebook.getStorage() < Integer.parseInt(criterionValue)) {
                            passFilter = false;
                        }
                        break;
                    case "3": // Операционная система
                        if (!notebook.getOs().equals(criterionValue)) {
                            passFilter = false;
                        }
                        break;
                    case "4": // Цвет
                        if (!notebook.getColor().equals(criterionValue)) {
                            passFilter = false;
                        }
                        break;
                }
            }

            if (passFilter) {
                System.out.println(notebook.getModel());
            }
        }
    }
}