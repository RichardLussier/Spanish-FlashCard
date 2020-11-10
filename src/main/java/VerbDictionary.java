/**
 * This class holds the methods for our dictionary, which
 * will hold the endings of the verb conjugations
 * @param <K>: the abstract key of our dictionary
 * @param <V>: the abstract value of our dictionary
 */
public class VerbDictionary<K, V> implements DictionaryInterface<K, V> {

    private Entry<K, V>[] dictionary;
    private static final int CAPACITY = 5;
    private int numberOFEntries;
    boolean integrityOK;

    public VerbDictionary(){
        dictionary = (Entry<K, V>[])new Entry[CAPACITY];
        numberOFEntries = 0;
        integrityOK = true;
    } //end of constructor

    /**
     * This method adds the key and value to the dictionary. If
     * the key already exists in the dictionary, we replace the old value
     * with the new one.
     * @param key: the key we want to add to the dictionary
     * @param value: the value we want to add to the dictionary
     * @return: the old value of the key, or null if it didn't exist beforehand
     */
    public V add(K key, V value){
        checkInitialization();
        V oldValue = null;
        if(contains(key)){
            int replaceAt = getIndexOf(key);
            oldValue = dictionary[replaceAt].getValue();
            dictionary[replaceAt].setValue(value);
        } //end of if
        dictionary[numberOFEntries] = new Entry(key, value);
        numberOFEntries++;
        return oldValue;
    } //end of add method

    /**
     * This method takes a key and returns whether the key exists in the dictionary
     * @param key: the key we want to search for
     * @return: true if the key is inside of the dictionary, false otherwise
     */
    private boolean contains(K key){
        return getIndexOf(key) != -1;
    } //end of contains method

    /**
     * This method find the index of a given key
     * @param key: the key we want to search for
     * @return: the index of the key, or -1 if it is not found
     */
    private int getIndexOf(K key){
        int index = 0;
        while(index < numberOFEntries){
            if(dictionary[index].getKey().equals(key))
                return index;
            index++;
        } //end of while
        return -1;
    } //end of getIndexOf method

    private void checkInitialization(){
        if(!integrityOK){
            throw new SecurityException("The dictionary has not been initialized");
        } //end of if
    } //end of checkInitialization method

    /**
     * This method will return the value of a given key
     * @param key: the key we want the value of
     * @return: the value of the key, or null otherwise
     */
    public V getValue(K key){
        V value = null;
        if(contains(key)){
            int index = getIndexOf(key);
            value = dictionary[index].getValue();
        } //end of if
        return value;
    } //end of getValue method

    /**
     * This inner class is for each entry inside of the dictionary
     * @param <K>: the abstract key of our entry
     * @param <V>: the abstract value of our entry
     */
    public class Entry<K, V>{

        K key;
        V value;

        public Entry(K searchKey, V newValue){
            key = searchKey;
            value = newValue;
        } //end of constructor

        private K getKey(){
            return key;
        } //end of getKey method

        private V getValue(){
            return value;
        } //end of getValue method

        public void setValue(V newValue){
            value = newValue;
        } //end of setValue method
    } //end of Entry inner class
} //end of Dictionary class
