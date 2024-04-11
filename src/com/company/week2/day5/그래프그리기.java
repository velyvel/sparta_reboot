package src.com.company.week2.day5;

public class 그래프그리기 {

    private int count;
    private int[][] vertexMatrix;

    public 그래프그리기(int count) {
        this.count = count;
        vertexMatrix = new int[count][count];
    }

    public void addEdge(int from, int to, int weight) {
        vertexMatrix[from][to] = weight;
        vertexMatrix[to][from] = weight;
    }

    public int[][] getVertexMatrix() {
        return vertexMatrix;
    }
}
