package trianglecenters.com.trianglecenters;

import android.app.Activity;
import android.app.AlertDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Orthocenter_Incenter_Circumcenter_CentroidActivity extends Activity {
    /**
     * Called when the activity is first created.
     */
    TextView t10, t12;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        t10 = (TextView) findViewById(R.id.textView10);
        t12 = (TextView) findViewById(R.id.textView12);
        Button b1 = (Button) findViewById(R.id.button1);
        b1.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                EditText e1 = (EditText) findViewById(R.id.editText1);
                EditText e2 = (EditText) findViewById(R.id.editText2);
                EditText e3 = (EditText) findViewById(R.id.editText3);
                EditText e4 = (EditText) findViewById(R.id.editText4);
                EditText e5 = (EditText) findViewById(R.id.editText5);
                EditText e6 = (EditText) findViewById(R.id.editText6);
                EditText e7 = (EditText) findViewById(R.id.editText7);
                EditText e8 = (EditText) findViewById(R.id.editText8);
                EditText e9 = (EditText) findViewById(R.id.editText9);
                TextView t11 = (TextView) findViewById(R.id.textView11);
                TextView t13 = (TextView) findViewById(R.id.textView13);
                if (e1.getText().length() != 0 && e2.getText().length() != 0 && e3.getText().length() != 0 && e4.getText().length() != 0 && e5.getText().length() != 0 && e6.getText().length() != 0 && e7.getText().length() != 0 && e8.getText().length() != 0 && e9.getText().length() != 0) {
                    float a1 = Float.parseFloat(e1.getText().toString());
                    float b1 = Float.parseFloat(e2.getText().toString());
                    float c1 = Float.parseFloat(e3.getText().toString());
                    float a2 = Float.parseFloat(e4.getText().toString());
                    float b2 = Float.parseFloat(e5.getText().toString());
                    float c2 = Float.parseFloat(e6.getText().toString());
                    float a3 = Float.parseFloat(e7.getText().toString());
                    float b3 = Float.parseFloat(e8.getText().toString());
                    float c3 = Float.parseFloat(e9.getText().toString());
                    float a = (float) Math.sqrt((a2 - a3) * (a2 - a3) + (b2 - b3) * (b2 - b3) + (c2 - c3) * (c2 - c3));
                    float b = (float) Math.sqrt((a1 - a3) * (a1 - a3) + (b1 - b3) * (b1 - b3) + (c1 - c3) * (c1 - c3));
                    float c = (float) Math.sqrt((a2 - a1) * (a2 - a1) + (b2 - b1) * (b2 - b1) + (c2 - c1) * (c2 - c1));
                    if ((!((a1 == a2 && b1 == b2 && c1 == c2) || (a2 == a3 && b2 == b3 && c2 == c3) || (a3 == a1 && b3 == b1 && c3 == c1))) && (a + b) != c && (b + c) != a && (c + a) != b) {
                        String cenx = String.valueOf(Math.round((a1 + a2 + a3) / 3 * 100.0) / 100.0);
                        String ceny = String.valueOf(Math.round((b1 + b2 + b3) / 3 * 100.0) / 100.0);
                        String cenz = String.valueOf(Math.round((c1 + c2 + c3) / 3 * 100.0) / 100.0);
                        t13.setText("Centroid:(" + cenx + "," + ceny + "," + cenz + ")");
                        String inx = String.valueOf(Math.round((a * a1 + b * a2 + c * a3) / (a + b + c) * 100.0) / 100.0);
                        String iny = String.valueOf(Math.round((a * b1 + b * b2 + c * b3) / (a + b + c) * 100.0) / 100.0);
                        String inz = String.valueOf(Math.round((a * c1 + b * c2 + c * c3) / (a + b + c) * 100.0) / 100.0);
                        t11.setText("Incenter:(" + inx + "," + iny + "," + inz + ")");
                        new LongOperation().execute(new Float(a1), new Float(b1), new Float(c1), new Float(a2), new Float(b2), new Float(c2), new Float(a3), new Float(b3), new Float(c3));
                        new Operation().execute(new Float(a1), new Float(b1), new Float(c1), new Float(a2), new Float(b2), new Float(c2), new Float(a3), new Float(b3), new Float(c3));
                        /*float[] p=new float[3];
                        p[0]=a2-a3;
                        p[1]=b2-b3;
                        p[2]=c2-c3;
                        float[] q=new float[3];
                        q[0]=a1-a3;
                        q[1]=b1-b3;
                        q[2]=c1-c3;
                        float[] nor=cpr(p,q);
                        float[] al1=cpr(nor,p);
                        float[] al2=cpr(nor,q);
                        ar[0][0] = al1[1];
                        ar[0][1] = -al1[0];
                        ar[0][2] = 0;
                        ar[0][3] = a1*al1[1]-b1*al1[0];
                        ar[1][0] = al2[1];
                        ar[1][1] = -al2[0];
                        ar[1][2] = 0;
                        ar[1][3] = a2*al2[1]-b2*al2[0];
                        ar[2][0] = 0;
                        ar[2][1] = al2[2];
                        ar[2][2] = -al2[1];
                        ar[2][3] = b2*al2[2]-b2*al2[1];
                        r = 0;
                        while (r < 3) {
                            int co = 2;
                            while (co > r) {
                                if (ar[r][r] != 0) {
                                    float d = ar[co][r] / ar[r][r];
                                    for (int i = 0; i <= 3; i++) {
                                        ar[co][i] = ar[co][i] - ar[r][i] * d;
                                    }
                                } else {
                                    for (int i = 0; i < 3; i++) {
                                        if (ar[i][r] != 0 && ar[r][i] != 0) {
                                            for (int j = 0; j < 4; j++) {
                                                ar[i][j] = ar[i][j] + ar[r][j];
                                                ar[r][j] = ar[i][j] - ar[r][j];
                                                ar[i][j] = ar[i][j] - ar[r][j];
                                            }
                                            break;
                                        }
                                    }
                                }
                                co--;
                            }
                            r++;
                        }
                            r = 2;
                            while (r > 0) {
                                int co = 0;
                                while (co < r) {
                                    if (ar[r][r] != 0) {
                                        float d = ar[co][r] / ar[r][r];
                                        for (int i = 0; i < 4; i++) {
                                            ar[co][i] = ar[co][i] - ar[r][i] * d;
                                        }
                                    } else {
                                        for (int i = 0; i < 3; i++) {
                                            if (ar[i][r] != 0 && ar[r][i] != 0) {
                                                for (int j = 0; j < 4; j++) {
                                                    ar[i][j] = ar[i][j] + ar[r][j];
                                                    ar[r][j] = ar[i][j] - ar[r][j];
                                                    ar[i][j] = ar[i][j] - ar[r][j];
                                                }
                                                break;
                                            }
                                        }
                                    }
                                    co++;
                                }
                                r--;
                            }
                        for (int x = 0; x < 3; x++) {
                            float d = 1 / ar[x][x];
                            for (int i =0; i < 4; i++) {
                                ar[x][i] = ar[x][i] * d;
                            }
                        }
                        float orthox = ar[0][3];
                        float orthoy = ar[1][3];
                        float orthoz = ar[2][3];
                        t10.setText("Orthocenter:(" + orthox + "," + orthoy + ","+orthoz+")");
                    */
                    } else {
                        AlertDialog alertDialog = new AlertDialog.Builder(Orthocenter_Incenter_Circumcenter_CentroidActivity.this).create();
                        alertDialog.setTitle("Invalid input!");
                        alertDialog.setMessage("The given values do not represent a triangle.");
                        alertDialog.setCanceledOnTouchOutside(true);
                        alertDialog.show();
                    }
                } else {
                    AlertDialog alertDialog = new AlertDialog.Builder(Orthocenter_Incenter_Circumcenter_CentroidActivity.this).create();
                    alertDialog.setTitle("Invalid input!");
                    alertDialog.setMessage("Please enter all the values.");
                    alertDialog.setCanceledOnTouchOutside(true);
                    alertDialog.show();
                }
            }
        });
    }

    public class LongOperation extends AsyncTask<Float, Void, float[]> {
        @Override
        protected float[] doInBackground(Float... val) {
            float[][] o = new float[3][3];
            int in = 0, jn = 0;
            for (Float s : val) {
                o[in][jn] = s;
                if (jn != 2) {
                    jn++;
                } else {
                    jn = 0;
                    in++;
                }
            }
            float[][] ar = new float[3][4];
            ar[0][0] = o[1][0] - o[0][0];
            ar[0][1] = o[1][1] - o[0][1];
            ar[0][2] = o[1][2] - o[0][2];
            ar[0][3] = (o[1][0] * o[1][0] - o[0][0] * o[0][0] + o[1][1] * o[1][1] - o[0][1] * o[0][1] + o[1][2] * o[1][2] - o[0][2] * o[0][2]) / 2;
            ar[1][0] = o[2][0] - o[1][0];
            ar[1][1] = o[2][1] - o[1][1];
            ar[1][2] = o[2][2] - o[1][2];
            ar[1][3] = (o[2][0] * o[2][0] - o[1][0] * o[1][0] + o[2][1] * o[2][1] - o[1][1] * o[1][1] + o[2][2] * o[2][2] - o[1][2] * o[1][2]) / 2;
            ar[2][0] = o[1][1] * o[2][2] - o[0][1] * o[2][2] - o[1][1] * o[0][2] - o[2][1] * o[1][2] + o[0][1] * o[1][2] + o[2][1] * o[0][2];
            ar[2][1] = o[0][0] * o[2][2] - o[1][0] * o[2][2] - o[0][0] * o[1][2] - o[2][0] * o[0][2] + o[1][0] * o[0][2] + o[2][0] * o[1][2];
            ar[2][2] = o[1][1] * o[2][0] - o[0][1] * o[2][0] - o[1][1] * o[0][0] - o[2][1] * o[1][0] + o[0][1] * o[1][0] + o[2][1] * o[0][0];
            ar[2][3] = o[0][0] * ar[2][0] + o[0][1] * ar[2][1] + o[0][2] * o[2][2];
            float inv[][] = new float[3][3];
            for(int i=0;i<3;i++)
            {
                for(int j=0;j<3;j++)
                {
                    double sign=(double)(1-(((i+j)%2)*2));
                    int k=0;
                    for(int ind=0;ind<3;ind++)
                    {
                        if(i!=ind)
                        {
                            int n=0;
                            for(int jnd=0;jnd<3;jnd++) {
                                if (jnd != j) {
                                    inv[k][n] = ar[ind][jnd];
                                }
                            }
                            k++;
                        }
                    }
                }
            }
            inv[0][0] = ar[1][1] * ar[2][2] - ar[1][2] * ar[2][1];
            inv[0][1] = -ar[1][0] * ar[2][2] + ar[1][2] * ar[2][0];
            inv[0][2] = ar[1][0] * ar[2][1] - ar[1][1] * ar[2][0];
            inv[1][0] = -ar[0][1] * ar[2][2] + ar[0][2] * ar[2][1];
            inv[1][1] = ar[0][0] * ar[2][2] - ar[0][2] * ar[2][0];
            inv[1][2] = -ar[0][0] * ar[2][1] + ar[0][1] * ar[2][0];
            inv[2][0] = ar[0][1] * ar[1][2] - ar[0][2] * ar[1][1];
            inv[2][1] = -ar[0][0] * ar[1][2] + ar[0][2] * ar[1][0];
            inv[2][2] = ar[0][0] * ar[1][1] - ar[0][1] * ar[1][0];
            float invt[][] = new float[3][3];
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    invt[i][j] = inv[j][i];
                }
            }
            float det = 0;
            for (int j = 0; j < 3; j++) {
                    det += ar[0][j] * inv[0][j];
                }
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    invt[i][j]/=det;
                }
            }
            float cir[]=new float[3];
            for(int i=0;i<3;i++)
            {
                cir[i]=0;
                for(int j=0;j<3;j++)
                {
                    cir[i]+=invt[i][j]*ar[j][3];
                }
                cir[i]=(float)((Math.round(cir[i]*100.0))/100.0);
            }
            cir[0]=inv[0][2];
            cir[1]=inv[1][2];
            cir[2]=inv[2][2];
            return cir;
        }
        @Override
        protected void onPostExecute(float[] result) {
            t12.setText("Circumcenter:(" + result[0] + "," + result[1] + "," + result[2] + ")");
        }

        @Override
        protected void onPreExecute() {
        }

        @Override
        protected void onProgressUpdate(Void... values) {
        }
    }
        public class Operation extends AsyncTask<Float, Void, float[]> {
            @Override
            protected float[] doInBackground(Float... val) {
                float[][] o = new float[3][3];
                int in = 0, jn = 0;
                for (Float s : val) {
                    o[in][jn] = s;
                    if (jn != 2) {
                        jn++;
                    } else {
                        jn = 0;
                        in++;
                    }
                }
                float[] p = new float[3];
                p[0] = o[1][0] - o[2][0];
                p[1] = o[1][1] - o[2][1];
                p[2] = o[1][2] - o[2][2];
                float[] q = new float[3];
                q[0] = o[0][0] - o[2][0];
                q[1] = o[0][1] - o[2][1];
                q[2] = o[0][2] - o[2][2];
                float[] nor = cpr(p, q);
                float[] al1 = cpr(nor, p);
                float[] al2 = cpr(nor, q);
                float[][] ar = new float[3][4];
                ar[0][0] = al1[1];
                ar[0][1] = -al1[0];
                ar[0][2] = 0;
                ar[0][3] = o[0][0] * al1[1] - o[0][1] * al1[0];
                ar[1][0] = al2[1];
                ar[1][1] = -al2[0];
                ar[1][2] = 0;
                ar[1][3] = o[1][0] * al2[1] - o[1][1] * al2[0];
                ar[2][0] = 0;
                ar[2][1] = al2[2];
                ar[2][2] = -al2[1];
                ar[2][3] = o[1][1] * al2[2] - o[1][2] * al2[1];
                int r = 0;
                while (r < 2) {
                    int co = 2;
                    while (co > r) {
                        if (ar[r][r] != 0) {
                            float d = ar[co][r] / ar[r][r];
                            for (int i = 0; i <= 3; i++) {
                                ar[co][i] = ar[co][i] - ar[r][i] * d;
                            }
                        } else {
                            for (int i = 0; i < 3; i++) {
                                if (ar[i][r] != 0 && ar[r][i] != 0) {
                                    for (int j = 0; j < 4; j++) {
                                        ar[i][j] = ar[i][j] + ar[r][j];
                                        ar[r][j] = ar[i][j] - ar[r][j];
                                        ar[i][j] = ar[i][j] - ar[r][j];
                                    }
                                    break;
                                }
                            }
                        }
                        co--;
                    }
                    r++;
                }
                r = 2;
                while (r > 0) {
                    int co = 0;
                    while (co < r) {
                        if (ar[r][r] != 0) {
                            float d = ar[co][r] / ar[r][r];
                            for (int i = 0; i < 4; i++) {
                                ar[co][i] = ar[co][i] - ar[r][i] * d;
                            }
                        } else {
                            for (int i = 0; i < 3; i++) {
                                if (ar[i][r] != 0 && ar[r][i] != 0) {
                                    for (int j = 0; j < 4; j++) {
                                        ar[i][j] = ar[i][j] + ar[r][j];
                                        ar[r][j] = ar[i][j] - ar[r][j];
                                        ar[i][j] = ar[i][j] - ar[r][j];
                                    }
                                    break;
                                }
                            }
                        }
                        co++;
                    }
                    r--;
                }
                for (int x = 0; x < 3; x++) {
                    float d = 1 / ar[x][x];
                    for (int i = 0; i < 4; i++) {
                        ar[x][i] = ar[x][i] * d;
                    }
                }
                float[] or = new float[3];
                or[0] = (float) (Math.round(ar[0][3] * 100.0) / 100.0);
                or[1] = (float) (Math.round(ar[1][3] * 100.0) / 100.0);
                or[2] = (float) (Math.round(ar[2][3] * 100.0) / 100.0);
                return or;
            }

            @Override
            protected void onPostExecute(float[] result) {
                t10.setText("Orthocenter:(" + result[0] + "," + result[1] + "," + result[2] + ")");
            }

            @Override
            protected void onPreExecute() {
            }

            @Override
            protected void onProgressUpdate(Void... values) {
            }

            public float[] cpr(float[] x, float[] y) {
                float[] re = new float[3];
                re[0] = x[1] * y[2] - x[2] * y[1];
                re[1] = x[2] * y[0] - x[0] * y[2];
                re[2] = x[0] * y[1] - x[1] * y[0];
                return re;
            }
        }
    }