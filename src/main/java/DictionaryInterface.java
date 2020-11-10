/**
 * This interface holds the methods needed for our dictionary, which holds the conjugations
 */
public interface DictionaryInterface<K, V> {

    /**
     * This method will add the key with the given value, or replace the value
     * @param key: the key we want to add
     * @param value: the value we want to add
     * @return: the old value assigned to the key, or null otherwise
     */
    public V add(K key, V value);

    /**
     * This methods retrieves the value of the given key
     * @param key: the key we want to find the value of
     * @return: the value of the key, or null if it didn't exist
     */
    public V getValue(K key);
} //end of DictionaryInterface interface
