import zio.*
import zio.stream.*

// https://adventofcode.com/2022/day/1

object Day1_CalorieCounting extends ZIOAppDefault:

    val string = "5794\n5879\n4899\n6777\n5845\n1303\n6761\n1814\n6605\n4715\n2264\n2789\n\n4684\n6694\n5840\n2705\n7269\n2127\n4265\n3944\n1134\n2623\n5617\n7191\n\n5293\n6742\n4208\n3218\n5967\n1617\n5433\n2938\n6337\n6694\n1597\n5727\n1734\n\n1745\n15953\n3781\n\n18680\n3460\n21833\n\n7434\n7346\n1116\n4079\n5013\n4597\n3730\n3660\n1595\n4501\n5908\n4847\n\n4357\n5306\n4632\n4808\n7222\n2487\n3772\n4656\n2316\n1876\n3029\n6280\n\n5298\n15504\n5338\n15522\n7264\n\n4253\n6912\n8254\n8559\n6364\n\n9485\n12425\n10047\n2934\n6686\n11651\n\n7701\n4660\n3241\n10868\n7111\n7973\n6048\n\n1549\n4669\n4199\n6211\n5297\n5535\n7972\n1615\n8711\n3803\n\n2562\n3344\n6535\n4892\n5025\n1972\n1734\n2671\n3380\n3682\n3990\n3602\n6649\n\n1641\n3404\n4608\n10732\n2157\n3435\n4416\n6776\n\n5487\n8946\n7325\n9531\n4851\n4976\n9406\n4848\n9058\n\n1883\n7711\n9300\n5638\n8096\n2885\n4520\n3024\n\n6044\n3910\n5663\n5250\n13826\n1469\n\n56667\n\n2437\n4404\n6875\n4034\n3906\n7256\n1054\n1436\n7231\n3858\n6880\n6449\n\n4737\n1421\n3682\n1389\n4492\n4821\n3875\n2907\n4357\n3759\n3224\n5005\n5712\n3098\n5864\n\n2407\n4258\n7987\n2085\n1802\n2838\n5100\n5815\n4602\n1617\n8058\n\n13874\n16855\n12120\n12266\n\n16448\n\n1693\n5327\n1443\n3932\n4648\n2142\n6757\n5190\n2704\n4759\n2954\n4681\n2702\n\n1525\n4403\n6818\n6125\n2535\n3955\n1859\n2265\n5915\n3137\n1961\n6610\n2133\n\n8152\n10276\n10852\n10244\n1459\n8134\n6686\n\n1807\n3470\n3171\n8803\n6592\n6954\n3109\n3305\n2393\n8381\n\n1688\n4232\n5952\n4896\n5610\n3247\n3249\n2628\n3325\n1628\n4876\n3829\n4656\n2871\n3571\n\n4133\n1826\n8072\n9227\n\n5784\n6032\n1491\n3691\n1206\n4398\n4794\n5852\n3215\n1779\n2362\n2175\n3580\n1929\n5469\n\n7469\n4215\n7364\n4310\n5277\n4668\n1030\n6087\n7521\n2959\n2878\n\n1672\n6020\n6047\n3580\n5766\n5859\n3605\n5630\n6545\n3512\n2841\n7216\n\n4731\n9911\n11359\n13234\n11676\n8120\n\n6618\n24252\n\n1530\n5230\n7254\n8009\n9010\n9620\n5119\n4598\n9687\n\n5159\n5686\n1788\n5088\n1938\n4131\n4612\n6038\n4220\n4521\n1550\n4918\n2501\n2504\n3077\n\n4439\n5145\n10897\n5844\n3709\n4495\n\n4139\n5134\n5328\n5474\n6064\n2589\n2809\n1653\n1494\n3337\n5593\n2546\n2905\n1093\n\n6920\n4134\n3878\n2094\n2573\n3692\n1148\n2302\n5412\n3658\n3024\n4709\n3181\n\n24826\n21716\n12659\n\n5770\n7224\n5016\n6369\n5626\n2550\n7297\n4664\n4919\n2545\n6251\n3846\n\n7482\n7360\n8577\n5502\n2145\n3763\n6408\n4769\n6610\n\n5739\n2098\n2385\n5588\n2409\n3387\n3623\n1372\n4403\n6322\n6026\n4003\n2653\n1568\n\n66601\n\n3188\n13831\n10244\n1496\n12540\n11285\n\n5301\n17714\n18376\n\n4464\n4720\n4548\n1519\n1955\n1675\n3495\n6326\n3434\n2450\n1450\n6297\n2557\n\n5980\n13288\n1545\n12018\n7961\n6012\n\n7880\n4981\n9901\n7816\n3172\n9490\n10029\n8410\n\n12095\n10481\n10933\n4235\n1106\n9284\n3133\n\n7579\n6723\n4875\n6147\n2017\n2566\n7641\n5163\n5477\n1134\n1661\n\n7135\n1013\n3218\n2549\n7639\n7299\n3924\n1942\n3199\n7851\n1217\n\n2512\n4356\n2482\n1178\n4521\n3400\n4333\n1726\n6308\n6277\n1143\n4962\n2837\n6507\n\n1305\n6109\n3115\n1205\n2172\n3416\n5558\n5227\n6017\n4503\n3088\n1560\n5945\n3679\n5448\n\n2977\n9069\n4530\n12642\n1821\n\n4452\n19214\n14527\n19883\n\n6361\n5748\n5999\n2580\n6697\n5402\n2422\n3183\n5503\n5993\n2567\n4208\n2004\n\n22562\n\n2656\n1112\n5664\n5517\n1301\n2184\n1646\n2851\n4817\n5350\n4074\n2133\n6169\n\n3933\n8419\n7256\n6770\n3469\n1438\n11003\n\n1456\n5635\n1933\n1196\n6686\n3245\n2141\n6819\n5743\n3614\n2485\n6829\n5244\n\n10649\n30106\n\n4766\n4779\n4134\n3761\n3088\n5477\n1892\n3585\n5867\n2566\n1960\n1922\n1577\n2091\n\n19270\n29017\n\n3108\n10282\n4623\n10377\n3570\n6322\n6958\n7057\n\n35355\n25911\n\n31705\n\n12443\n2062\n1464\n8206\n3083\n13052\n\n19188\n16088\n3927\n11479\n\n2421\n5453\n2946\n3118\n2456\n5152\n5604\n2909\n2020\n5040\n7498\n\n10666\n5120\n10166\n6616\n2151\n6102\n\n4463\n32308\n\n6447\n6712\n1183\n4264\n1824\n1533\n1403\n7320\n2204\n1865\n1887\n\n13860\n5324\n10272\n10859\n1615\n1345\n\n21147\n20301\n24255\n\n57301\n\n16407\n9592\n3822\n11186\n9812\n\n2436\n9609\n5163\n6263\n4182\n10301\n\n22997\n3077\n15477\n\n2379\n5970\n5429\n1283\n4580\n4126\n2592\n6285\n2669\n1612\n6320\n5087\n2941\n6433\n\n33200\n\n6861\n9236\n1301\n12712\n14165\n\n8933\n5205\n11578\n1523\n10091\n7515\n\n2376\n11526\n15587\n13513\n12834\n\n4796\n2358\n6422\n4603\n6920\n3971\n1899\n7821\n3885\n1718\n8039\n\n16063\n\n4537\n6714\n1857\n5871\n6182\n9996\n4217\n6483\n\n5059\n4145\n3818\n3898\n3896\n3085\n4477\n1476\n6014\n3545\n5200\n5363\n5866\n3218\n2466\n\n5648\n4125\n4125\n4912\n3651\n6606\n2230\n6221\n6480\n7240\n7302\n5600\n\n2273\n3832\n3343\n2207\n1359\n5842\n5131\n4928\n3466\n6427\n3191\n6623\n1885\n\n1158\n1687\n6243\n8632\n2634\n9070\n4482\n3477\n8077\n\n1593\n1220\n2601\n3283\n5779\n5161\n6210\n4752\n1137\n7443\n3161\n5268\n\n8847\n3825\n5688\n6218\n4998\n10218\n9792\n\n3549\n1562\n11437\n6479\n4094\n1537\n11888\n\n7069\n4924\n7235\n7244\n4942\n6144\n5175\n1472\n5395\n1776\n6968\n6417\n\n5962\n5599\n11740\n3693\n11159\n9934\n10682\n\n6246\n23393\n3247\n\n64480\n\n28558\n23959\n\n4732\n4052\n4660\n2032\n2537\n6107\n4976\n1510\n2342\n2037\n1961\n2120\n3331\n5388\n2840\n\n4738\n4435\n9965\n10755\n9136\n2779\n3494\n7568\n\n11962\n12956\n12901\n1053\n15933\n\n8344\n4378\n4982\n8580\n5246\n4652\n1197\n1209\n4898\n2905\n\n7828\n2797\n6653\n3897\n11216\n4896\n5650\n\n5060\n5783\n1814\n4749\n1884\n2609\n6175\n5615\n6674\n4203\n6060\n1345\n5485\n\n6323\n5968\n3726\n3863\n2986\n2218\n2389\n6289\n4369\n2472\n5961\n4442\n4902\n2875\n\n5480\n2082\n1907\n3069\n6594\n6621\n6692\n3164\n4281\n5764\n2844\n5682\n\n4652\n3059\n1388\n7547\n7804\n5770\n4792\n4181\n5903\n6609\n4468\n\n5470\n1039\n13220\n6244\n12612\n6790\n\n3762\n1435\n6236\n5328\n5577\n4420\n5485\n6727\n3656\n3583\n1089\n3468\n4795\n\n19632\n\n10092\n3698\n4674\n10270\n4097\n8378\n9019\n2101\n\n4001\n7242\n7841\n7903\n8072\n2704\n3750\n1335\n9390\n\n5466\n8448\n4827\n3673\n2489\n7995\n3362\n6592\n1453\n2353\n\n10382\n15140\n10465\n7746\n\n1061\n3623\n9453\n8621\n10641\n8431\n9650\n8132\n\n13431\n4971\n\n10121\n9985\n8609\n5410\n9424\n1115\n8339\n1319\n\n1991\n5002\n6099\n3845\n5373\n5072\n6950\n7134\n4229\n6917\n2796\n3188\n\n6805\n2159\n1436\n6231\n1280\n5023\n3806\n3864\n1801\n5281\n3623\n3162\n6226\n\n14847\n1007\n1553\n15502\n5373\n\n6737\n6519\n1991\n2974\n5339\n1614\n4366\n6332\n4183\n5651\n4116\n4057\n6751\n\n6117\n5537\n4339\n5262\n5216\n3861\n1269\n6111\n4720\n3285\n3533\n4639\n1602\n2301\n1684\n\n13962\n4475\n7421\n5710\n\n1842\n13774\n7371\n5183\n\n15576\n10011\n21697\n\n1703\n6327\n1474\n2647\n2047\n1994\n5821\n5290\n5378\n3163\n6715\n1462\n5716\n\n6500\n4135\n15482\n16325\n7377\n\n4911\n3898\n7024\n4504\n8418\n3523\n7429\n1875\n1080\n3896\n\n2364\n3213\n7568\n3554\n7065\n2300\n6145\n3674\n2579\n\n6046\n2600\n3260\n1078\n4308\n5966\n4546\n2863\n4482\n5451\n5083\n1346\n6098\n5558\n3886\n\n7594\n4850\n7782\n4683\n3996\n5939\n5193\n1411\n5856\n6158\n4151\n\n9371\n7675\n4379\n4898\n6149\n7880\n4419\n3487\n3022\n\n5027\n10030\n6295\n6916\n6102\n11647\n\n2305\n7373\n2844\n5653\n2048\n2659\n7491\n\n6571\n6102\n1435\n1680\n7241\n2643\n5597\n2855\n6189\n4513\n1702\n5352\n\n3268\n4805\n3361\n4880\n2674\n7713\n7487\n8168\n1734\n7110\n\n8153\n2756\n3447\n6789\n7761\n4724\n7481\n1835\n7373\n1573\n\n6151\n6557\n6501\n1718\n4891\n4249\n1061\n2182\n6793\n5499\n5558\n5594\n6515\n\n9371\n1943\n5818\n4018\n2133\n5379\n1396\n4527\n4334\n\n27222\n\n7807\n4918\n13254\n5437\n1057\n11915\n\n50918\n\n17389\n8573\n6769\n3223\n\n6566\n7265\n7661\n2280\n2889\n6519\n7076\n5678\n4216\n3959\n5216\n\n14059\n21822\n\n16926\n5947\n15846\n\n1421\n7117\n3267\n5141\n3504\n6315\n6485\n5849\n6779\n7299\n7087\n6235\n\n5454\n6529\n6087\n8667\n7271\n6205\n3395\n7376\n4309\n\n13097\n10266\n10587\n8406\n5973\n\n31623\n19233\n\n48107\n\n4736\n1411\n3464\n2467\n3720\n5645\n6533\n1354\n4376\n5188\n1840\n1109\n2649\n\n4624\n3867\n4932\n4705\n4752\n6636\n6935\n1763\n6683\n3182\n1279\n\n4190\n1834\n4102\n2157\n1314\n4346\n4749\n4598\n2664\n5343\n1153\n2883\n2176\n2972\n5991\n\n41319\n\n10951\n3590\n3511\n10163\n\n5379\n5046\n6185\n3099\n1479\n5463\n2003\n5895\n7133\n2941\n2377\n5604\n\n1988\n3312\n4445\n6210\n4515\n1936\n1028\n3815\n7004\n6010\n3296\n6532\n\n10653\n13005\n6246\n5002\n11939\n2610\n\n2542\n1469\n4189\n5227\n2742\n3595\n1098\n1684\n1866\n2099\n3674\n3253\n1097\n4537\n5492\n\n2503\n2386\n6625\n6206\n3044\n6910\n6005\n3726\n6556\n2116\n3373\n6039\n\n5253\n2117\n7428\n2920\n3028\n6779\n5893\n2150\n5131\n3665\n4618\n6213\n\n23441\n14459\n\n3721\n7052\n5815\n5578\n7148\n2382\n4461\n5179\n3268\n7011\n4608\n5815\n\n1426\n3853\n2734\n2087\n3561\n5430\n3453\n2662\n3850\n4482\n5771\n3764\n3698\n4567\n4285\n\n6201\n23437\n21958\n\n45685\n\n1018\n4012\n2564\n1444\n6782\n2350\n5347\n2245\n6350\n1964\n6361\n3612\n\n25442\n30894\n\n7174\n6713\n7375\n1569\n6526\n5476\n6307\n1437\n3142\n1224\n2845\n4229\n\n17039\n22539\n14263\n\n5261\n6706\n18415\n\n9354\n\n2060\n5488\n5252\n4729\n1494\n1468\n1770\n6272\n4686\n1550\n2431\n3345\n\n4333\n2475\n5919\n3201\n4253\n5595\n3763\n3299\n4557\n2466\n3908\n3506\n3666\n6102\n3271\n\n2526\n6329\n4580\n6450\n3137\n3627\n2978\n1763\n3776\n4012\n3483\n6696\n6715\n\n20837\n\n6938\n4996\n2997\n1959\n4351\n2683\n6707\n6776\n7725\n\n7454\n5422\n1719\n3273\n1263\n5817\n7068\n4047\n6591\n5467\n\n25504\n13811\n1728\n\n7332\n7843\n4698\n6364\n4560\n4973\n1579\n7189\n7706\n3898\n7777\n\n2498\n3156\n2239\n5544\n5429\n5064\n3026\n3912\n5425\n2800\n2690\n3519\n1680\n4607\n5627\n\n2848\n4523\n3083\n4742\n6058\n7632\n5695\n5896\n4150\n\n7436\n7171\n6346\n6022\n3973\n7600\n6350\n2170\n2330\n2961\n2807\n\n11194\n5672\n8861\n3820\n2318\n3608\n2535\n\n4356\n1035\n2326\n2168\n4696\n3235\n3912\n3714\n2892\n1505\n2985\n3962\n5379\n5869\n2468\n\n6176\n19825\n12752\n1789\n\n6406\n4926\n2937\n5045\n6899\n6051\n6029\n4221\n6758\n3748\n2254\n5546\n6196\n\n4197\n6095\n4615\n12118\n4239\n11880\n\n5962\n6436\n2413\n1834\n3428\n2752\n3426\n2443\n2117\n4483\n3577\n2703\n4323\n2041\n\n4511\n11096\n3091\n5826\n6323\n11881\n8688\n\n3772\n5248\n3519\n1105\n5984\n1610\n5661\n1737\n2428\n2766\n1534\n4456\n1735\n1924\n4874\n\n10428\n10725\n4803\n6867\n8574\n8520\n5612\n5855\n\n28835\n18115\n\n1549\n8536\n5806\n2597\n3777\n7724\n5803\n1500\n3754\n\n17046\n19405\n3079\n\n18363\n14060\n7675\n2603\n\n2739\n2195\n1068\n4517\n5300\n4683\n6321\n6529\n3037\n\n12958\n2464\n10649\n10001\n5557\n13397\n\n6673\n3375\n9252\n9005\n3761\n9191\n7424\n7279\n8629\n\n26298\n8367\n\n3330\n4691\n6352\n7291\n2422\n1107\n3173\n5061\n4711\n4706\n4300\n3218\n\n26181\n\n2972\n2339\n9322\n1076\n2682\n4852\n7622\n\n5641\n19288\n2918\n6314\n\n3951\n2584\n5634\n1905\n5291\n1157\n3181\n1818\n3722\n4802\n4111\n2522\n3001\n4358\n2120\n\n1077\n5533\n6400\n5381\n1006\n3449\n3155\n5997\n5918\n5556\n3050\n5280\n4295\n3936\n\n9584\n8280\n6414\n2734\n7417\n4789\n6142\n8495\n8052\n\n1327\n2087\n4527\n1098\n7191\n5222\n2375\n4037\n3780\n5426\n7144\n3261\n\n37178\n\n8043\n5217\n3272\n7191\n7990\n4697\n5140\n4541\n1169\n6205\n\n6475\n12269\n8879\n18444\n\n3075\n6082\n6593\n3094\n7802\n1862\n1994\n\n10270\n7508\n14080\n5226\n11093\n\n4093\n1046\n3565\n6243\n3054\n2416\n5708\n4547\n4317\n4341\n5802\n1029\n4809\n\n12551\n\n1105\n2947\n1508\n3953\n5390\n5139\n2045\n2040\n2028\n3621\n3594\n5765\n\n4868\n5464\n4166\n1186\n1258\n5494\n1170\n2962\n4244\n2177\n5152\n4306\n5704\n2623\n5144\n\n3933\n2777\n4077\n1728\n2543\n5292\n5055\n3498\n4288\n1910\n3631\n3266\n1959\n3334\n2893\n\n12920\n36997\n\n15084\n8596\n1619\n10189\n3402\n\n5283\n2209\n4246\n1049\n7820\n1955\n1352\n6554\n7904\n6596\n3101\n\n1732\n4551\n2842\n3485\n7432\n3587\n6443\n2499\n6964\n2325\n2001\n3936\n\n2065\n11158\n3711\n7948\n1256\n\n4646\n1220\n2075\n2517\n1612\n5728\n7408\n4255\n6139\n7265\n2205\n\n20078\n12781\n15413\n\n32493\n\n12425\n5567\n1944\n\n20490\n6224\n6355\n\n2558\n3063\n4979\n4005\n4809\n1217\n6848\n6919\n6050\n1764\n1266\n1167\n1613\n\n17719\n26741\n\n5544\n13291\n2641\n12677\n14592\n\n12413\n7876\n16123\n\n8473\n9063\n2322\n6576\n12504\n\n5141\n8613\n10753\n9990\n2696\n8297\n10125\n\n8306\n6741\n8581\n6900\n4450\n1230\n6466\n1410\n6566\n\n1735\n6150\n4168\n8651\n9338\n6301\n2437\n7349\n7270\n\n5556\n5479\n4120\n2487\n4016\n5148\n4606\n3867\n5898\n5437\n3614\n2078\n2827\n5082\n4730\n\n5361\n2506\n6122\n8706\n4328\n3030\n5801\n5956\n6575\n3166\n\n5822\n2501\n3165\n5617\n2996\n4302\n4263\n5136\n6668\n3181\n1277\n1575\n\n6963\n5403\n5751\n4803\n12025\n1235\n8890\n\n2986\n3255\n5464\n3489\n3015\n6330\n5748\n2278\n5330\n1435\n5005\n3697\n1570\n6487\n\n2381\n4178\n7190\n1615\n4813\n7485\n5712\n3673\n6748\n6428\n\n6701\n15260\n16317\n3748\n\n5146\n3783\n9166\n13869\n6908\n\n7106\n9860\n2413\n6842\n8605\n11235\n4771\n\n6745\n6142\n6972\n3538\n2115\n4595\n9610\n\n7403\n7136\n2601\n6422\n2010\n2244\n8805"

    def run =
        val summedCaloriesStream = calculateCalorieSum(createInputStream(string))
        for
            mostCalories <- findMostCalories(summedCaloriesStream)
            top3Calories <- findTop3Calories(summedCaloriesStream)
            _ <- Console.printLine("most calories: " + mostCalories)
            _ <- Console.printLine("top 3 calories: " + top3Calories)
        yield ()

    def createInputStream(values: String): UStream[Array[Int]] =
        ZStream.fromChunk(
            Chunk.fromArray(
                values.split("\n\n")
                    .map(_.split("\n").map(_.toInt))
            )
        )

    def calculateCalorieSum(inputStream: UStream[Array[Int]]): UStream[Int] =
        inputStream.map(_.sum)

    def findMostCalories(summedCaloriesStream: UStream[Int]): UIO[Int] =
        summedCaloriesStream.runFold(0)((x, y) => scala.math.max(x, y))

    def findTop3Calories(summedCaloriesStream: UStream[Int]): URIO[Scope, Int] =
        summedCaloriesStream.toIterator
            .map(x =>
                Chunk.fromIterator(x.map(y => y.merge))
                    .sorted
                    .reverse
                    .take(3)
                    .sum
            )