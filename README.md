# MySnakebar
    ```
    Snackbar sna = Snackbar.make(mRlv, "", Snackbar.LENGTH_INDEFINITE);
                sna.setActionTextColor(Color.parseColor("#fb595b"));
                sna.getView().setBackgroundColor(Color.parseColor("#5b6066"));
                sna.setAction("点击", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(MainActivity.this, "点击", Toast.LENGTH_SHORT).show();
                    }
                });
                sna.show();
                
                ```
