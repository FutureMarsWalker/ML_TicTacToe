public class Network {
    // This class is the whole neural network. This network will work with anything, it only needs target values.
    private double[][] output;
    private double[][][] weights;
    private double[][] bias;

    private double[][] error_signal;
    private double[][] output_derivative;

    public final int[] NETWORK_LAYER_SIZES;
    public final int INPUT_SIZE;
    public final int OUTPUT_SIZE;
    public final int NETWORK_SIZE;

    //static
    static Cell compCell;
    static double[] target = {};
    static double[] finalAnswer = {};

    public Network(int... NETWORK_LAYER_SIZES){

        this.NETWORK_LAYER_SIZES = NETWORK_LAYER_SIZES;
        this.INPUT_SIZE = NETWORK_LAYER_SIZES[0];
        this.NETWORK_SIZE = NETWORK_LAYER_SIZES.length;
        this.OUTPUT_SIZE = NETWORK_LAYER_SIZES[NETWORK_SIZE - 1];
        this.output = new double[NETWORK_SIZE][];
        this.weights = new double[NETWORK_SIZE][][];
        this.bias = new double[NETWORK_SIZE][];

        this.error_signal = new double[NETWORK_SIZE][];
        this.output_derivative = new double[NETWORK_SIZE][];

        for(int i = 0; i < NETWORK_SIZE; i++){

            this.output[i] = new double[NETWORK_LAYER_SIZES[i]];
            this.bias[i] = NetworkTools.createRandomArray(NETWORK_LAYER_SIZES[i], 0.3, 0.7);

            this.error_signal[i] = new double[NETWORK_LAYER_SIZES[i]];
            this.output_derivative[i] = new double[NETWORK_LAYER_SIZES[i]];

            if(i > 0){

                weights[i] = NetworkTools.createRandomArray(NETWORK_LAYER_SIZES[i], NETWORK_LAYER_SIZES[i - 1], -0.3, -0.5);

            }

        }

    }

    public double[] calculate(double... input){

        if(input.length != this.INPUT_SIZE){

            return null;

        }

        this.output[0] = input;

        for(int layer = 1; layer < NETWORK_SIZE; layer++){

            for(int neuron = 0; neuron < NETWORK_LAYER_SIZES[layer]; neuron++){

                double sum = bias[layer][neuron];
                for(int prevNeuron = 0; prevNeuron < NETWORK_LAYER_SIZES[layer - 1]; prevNeuron++){

                    sum += output[layer -1][prevNeuron] * weights[layer][neuron][prevNeuron];

                }

                output[layer][neuron] = sigmoid(sum);
                output_derivative[layer][neuron] = output[layer][neuron] * (1 - output[layer][neuron]);

            }

        }

        return output[NETWORK_SIZE - 1];

    }

    public void train(double[] input, double[] target, double learningRate){

        if(input.length != INPUT_SIZE || target.length != OUTPUT_SIZE){
            return;
        }
        calculate(input);
        backpropError(target);
        updateWeights(learningRate);

    }

    public void backpropError(double[] target){

        for(int neuron = 0; neuron < NETWORK_LAYER_SIZES[NETWORK_SIZE - 1]; neuron ++){

            error_signal[NETWORK_SIZE - 1][neuron] = (output[NETWORK_SIZE - 1][neuron] - target[neuron]) * output_derivative[NETWORK_SIZE - 1][neuron];

        }

        for(int layer = NETWORK_SIZE - 2; layer > 0; layer --){

            for(int neuron = 0; neuron < NETWORK_LAYER_SIZES[layer]; neuron ++){

                double sum = 0;
                for(int nextNeuron =0; nextNeuron < NETWORK_LAYER_SIZES[layer + 1]; nextNeuron ++){
                    sum += weights[layer + 1][nextNeuron][neuron] * error_signal[layer + 1][nextNeuron];
                }
                this.error_signal[layer][neuron] = sum * output_derivative[layer][neuron];
            }

        }

    }

    public void updateWeights(double learningRate){

        for(int layer = 1; layer < NETWORK_SIZE; layer++){

            for(int neuron = 0; neuron < NETWORK_LAYER_SIZES[layer]; neuron++){

                double delta = -learningRate * error_signal[layer][neuron];
                bias[layer][neuron] += delta;

                for(int prevNeuron = 0; prevNeuron < NETWORK_LAYER_SIZES[layer - 1]; prevNeuron++){

                    weights[layer][neuron][prevNeuron] += delta * output[layer - 1][prevNeuron];

                }

            }

        }

    }

    private double sigmoid(double x){

        return 1d / (1 + Math.exp(-x));

    }

    public static void netTarget(Cell compareTo) {
        Network net = new Network(9, 3, 3, 9);

        double[] input = new double[]{Math.random() * 1, Math.random() * 1, Math.random() * 1, Math.random() * 1, Math.random() * 1,
                Math.random() * 1, Math.random() * 1, Math.random() * 1, Math.random() * 1};

        switch (compareTo.toString()) {
            case "(0, 0)":
                target = new double[]{1, 0, 0, 0, 0, 0, 0, 0, 0};
                break;
            case "(0, 1)":
                target = new double[]{0, 1, 0, 0, 0, 0, 0, 0, 0};
                break;
            case "(0, 2)":
                target = new double[]{0, 0, 1, 0, 0, 0, 0, 0, 0};
                break;
            case "(1, 0)":
                target = new double[]{0, 0, 0, 1, 0, 0, 0, 0, 0};
                break;
            case "(1, 1)":
                target = new double[]{0, 0, 0, 0, 1, 0, 0, 0, 0};
                break;
            case "(1, 2)":
                target = new double[]{0, 0, 0, 0, 0, 1, 0, 0, 0};
                break;
            case "(2, 0)":
                target = new double[]{0, 0, 0, 0, 0, 0, 1, 0, 0};
                break;
            case "(2, 1)":
                target = new double[]{0, 0, 0, 0, 0, 0, 0, 1, 0};
                break;
            case "(2, 2)":
                target = new double[]{0, 0, 0, 0, 0, 0, 0, 0, 1};
                break;
        }

        for (int i = 0; i < 10000; i++) {
            net.train(input, target, 0.3);
        }

        finalAnswer = net.calculate(input);
        double biggest = 0.0;

        for (double v : finalAnswer) {
            if (v > biggest) {
                biggest = v;
            }
        }


        for(int i = 0; i < finalAnswer.length; i++){
            if(finalAnswer[i] == biggest){
                switch (i){
                    case 0:
                        compCell = new Cell(0, 0);
                        break;
                    case 1:
                        compCell = new Cell(0, 1);
                        break;
                    case 2:
                        compCell = new Cell(0, 2);
                        break;
                    case 3:
                        compCell = new Cell(1, 0);
                        break;
                    case 4:
                        compCell = new Cell(1, 1);
                        break;
                    case 5:
                        compCell = new Cell(1, 2);
                        break;
                    case 6:
                        compCell = new Cell(2, 0);
                        break;
                    case 7:
                        compCell = new Cell(2, 1);
                        break;
                    case 8:
                        compCell = new Cell(2, 2);
                        break;
                }
            }
        }
    }

}
