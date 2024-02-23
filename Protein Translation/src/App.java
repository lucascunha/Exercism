import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

public class App {
    public static void main(String[] args) throws Exception {
        String rnaSequence = "AUGUUUUCU";

        String protein = transform(rnaSequence);

        System.out.println("Protein: " + protein);

        rnaSequence = "AUGUUUUCUUAAAUG";
        protein = transform(rnaSequence);
        System.out.println("Protein: " + protein);
    }

    public static String transform(String rna) {
        List<String> protein = new ArrayList<>();

        // Tabela Codons x Aminoacidos
        LinkedHashMap<String, String> aminoacids = new LinkedHashMap<>();
        aminoacids.put("Methionine", "AUG");
        aminoacids.put("Phenylalanine", "UUU/UUC");
        aminoacids.put("Leucine", "UUA/UUG");
        aminoacids.put("Serine", "UCU/UCC/UCA/UCG");
        aminoacids.put("Tyrosine", "UAU/UAC");
        aminoacids.put("Cysteine", "UGU/UGC");
        aminoacids.put("Tryptophan", "UGG");
        aminoacids.put("STOP", "UAA/UAG/UGA");

        // Codons na sequencia de RNA
        String[] codons = rna.split("(?<=\\G.{3})");

        for (String aminoAcid : aminoacids.keySet()) {
            for (String codon : codons) {
                if (aminoacids.get("STOP").contains(codon)) {
                    break;
                } else if (aminoacids.get(aminoAcid).contains(codon)) {
                    protein.add(aminoAcid);
                }
            }
        }

        return protein.toString();
    }
}
