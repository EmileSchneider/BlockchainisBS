import java.util.ArrayList;

public class Blockchain {

    private ArrayList<Block> blockchain;

    public Blockchain(){
        blockchain = new ArrayList<Block>();
        blockchain.add(genesisBlock());
    }

    private Block genesisBlock(){
        return new Block(Utils.hash("alohimbaruch"));
    }

    public void addBlock(Block block){
        if (blockchain.get(-1).getHash() == block.getPreviousHash()) {
            if(block.getHash().charAt(0) == '0'){
                if(Utils.hash(block.hashstring()) == block.getHash()){
                    blockchain.add(block);
                }
            }
        }
    }
    public Block currentBlock() {
        return blockchain.get(blockchain.size() - 1);
    }

    public String printBlockchain(){
        String bsstring = new String();
        for(Block b : blockchain){
            bsstring = bsstring + '\n' + b.printBlock();
        }
        return bsstring;
    }



}
