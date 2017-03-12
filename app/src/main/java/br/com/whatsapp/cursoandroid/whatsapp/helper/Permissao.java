package br.com.whatsapp.cursoandroid.whatsapp.helper;

import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Melqui on 18/02/2017.
 */

public class Permissao {

    public  static  boolean validaPermissoes(int requestCode, Activity activity, String[] permissoes){

        if(Build.VERSION.SDK_INT >= 23){

            ArrayList<String> listaDePermissoes = new ArrayList<String>();

            for (String permissao : permissoes) {

                Boolean validaPermissao =
                        ContextCompat.checkSelfPermission(activity, permissao) == PackageManager.PERMISSION_GRANTED;
                if (!validaPermissao){
                    listaDePermissoes.add(permissao);
                }
            }

            if (listaDePermissoes.isEmpty()){
                return true;
            }

            String[] arrayDePermissoes = new String[listaDePermissoes.size()];
            listaDePermissoes.toArray(arrayDePermissoes);

            ActivityCompat.requestPermissions(activity, arrayDePermissoes , requestCode);



        }

        return true;

    }
}
